import org.checkerframework.checker.units.qual.C;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Movements {

    public Movements(String pathMovementsCsv) {
        Client.getClientList().clear();
        readFile(Path.of(pathMovementsCsv));
        firstAction();
    }

    private List<String> dataList = new ArrayList<>();

    private void readFile(Path path) {
        try {
            dataList = Files.readAllLines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public double getExpenseSum() {
        double expenseSum = 0;
        for (Client client : Client.getClientList()) {
            for (String operation : client.getOperationData()) {
                String[] fragments = operation.split("\t");
                expenseSum += Double.parseDouble(fragments[3]);
            }
        }
        return expenseSum;
    }

    public double getIncomeSum() {

        double incomeSum = 0;
        for (Client client : Client.getClientList()) {
            for (String operation : client.getOperationData()) {
                String[] fragments = operation.split("\t");
                incomeSum += Double.parseDouble(fragments[2]);
            }
        }
        return incomeSum;
    }

    public String expenseSumFromOrganizations() {
        String expenseSumFromOrganizations = "";
        for (Organization organization : Organization.getOrganizationArrayList()) {
            expenseSumFromOrganizations += organization.getOrganizationName() +
                    ": " + organization.getOrganizationIncomeSum() + " руб." + "\n";
        }
        return expenseSumFromOrganizations;
    }

    private void firstAction() {
        try {
            for (String line : dataList) {

                if (line.equals(dataList.get(0))) {
                    continue;
                }

                String[] fragmentsFirst = firstBlockFormat(line);

//                Разделили по фрагментам первый блок из выписки

                String organizationName = getOrganizationNameFormat(line);

                Organization organization = Organization.getOrganization(organizationName);

//                Вычислили организацию

                String[] fragmentsSecond = lastBlockFormat(line);

//                Разделили последний блок из выписки


                Client client = null;

                for (Client clientThis : Client.getClientList()) {
                    if (clientThis.getAccountNumber().equals(fragmentsFirst[1])) {
                        client = clientThis;
                    }
                }

                if (client == null) {
                    client = new Client(fragmentsFirst[1]);
                }

                String opData = fragmentsFirst[3] + "\t"
                        + fragmentsSecond[0] + "\t"
                        + fragmentsSecond[1] + "\t"
                        + fragmentsSecond[2] + "\t"
                        + organization.getOrganizationName() + "\t"
                        + fragmentsFirst[4];

                organization.addOrganizationIncome(Double.parseDouble(fragmentsSecond[2]));

                if (!client.getOperationData().contains(opData)) {
                    client.addOperationData(opData);
                }

            }

        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private String[] firstBlockFormat(String line) {
        int end = line.indexOf(' ', 1);
        end = line.indexOf(' ', ++end);
        line = line.substring(0, end);
        String[] fragmentsFirst = line.split(",");
        if (fragmentsFirst.length != 6) {
            throw new IllegalArgumentException("Неверное количество фрагментов1");
        }
        return fragmentsFirst;
    }

    private String getOrganizationNameFormat(String line) {
        int end = line.indexOf(' ', 1);
        end = line.indexOf(' ', ++end);
        int start = end;
        end = line.indexOf(' ', end);
        line = line.substring(start);
        line = line.trim();
        end = line.indexOf(' ');
        end = line.indexOf(' ', ++end);
        end = line.indexOf(' ', ++end);
        end = line.indexOf(' ', ++end);
        line = line.substring(0, end);
        line = line.trim();
        start = line.lastIndexOf("\\");
        line = line.substring(++start);
        return line;
    }

    private String[] lastBlockFormat(String line) {
        int start = line.lastIndexOf(' ');
        line = line.substring(++start);

        if (line.indexOf('\"') != -1) {
            start = line.indexOf('\"');
            int end = line.indexOf('\"', ++start);
            String dValue = line.substring(start, ++end);
            dValue = dValue.replaceAll(",", ".");
            line = line.substring(0, start) + dValue + line.substring(end);
            line = line.replaceAll("\"", "");
        }

        String[] fragmentsSecond = line.split(",");
        if (fragmentsSecond.length != 3) {
            throw new IllegalArgumentException("Неверное количество фрагментов2");
        }

        return fragmentsSecond;
    }
}
