import java.util.ArrayList;
import java.util.TreeSet;

public class Client {

    public Client(String accountNumber) {
        this.accountNumber = accountNumber;
        clientList.add(this);
    }

    private static ArrayList<Client> clientList = new ArrayList<>();

    public static ArrayList<Client> getClientList() {
        return clientList;
    }

    private String accountNumber;
    private ArrayList<String> operationData = new ArrayList<>();

    public String getAccountNumber() {
        return accountNumber;
    }

    public void addOperationData(String data) {
        operationData.add(data);
    }

    public ArrayList<String> getOperationData() {
        return operationData;
    }

}
