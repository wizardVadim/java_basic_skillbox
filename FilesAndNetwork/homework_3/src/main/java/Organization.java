import java.util.ArrayList;

public class Organization {

    private final String organizationName;

    public double getOrganizationIncomeSum() {
        return organizationIncomeSum;
    }

    private double organizationIncomeSum;

    private static ArrayList<Organization> organizationArrayList =
            new ArrayList<>();

    private Organization(String name) {
        organizationName = name;
        organizationArrayList.add(this);
    }

    public void addOrganizationIncome(double organizationIncomeSum) {
        this.organizationIncomeSum += organizationIncomeSum;
    }

    private static boolean isOrganizationFromList(String organization) {

        boolean isOrganizationFromList = false;

        if (!organizationArrayList.isEmpty()) {

            for (Organization organizationFromList : organizationArrayList) {
                if (organizationFromList.getOrganizationName().equals(organization)) {
                    isOrganizationFromList = true;
                }
            }
        }

        return  isOrganizationFromList;
    }

    public static Organization getOrganization(String name) {
        Organization organization = null;

        if (!isOrganizationFromList(name)) {
            organization = new Organization(name);
        } else {
            for (Organization organizationFromList : organizationArrayList) {
                if (organizationFromList.getOrganizationName().equals(name)) {
                    organization = organizationFromList;
                }
            }
        }

        return organization;

    }

    public String getOrganizationName() {
        return organizationName;
    }

    public static ArrayList<Organization> getOrganizationArrayList() {
        return organizationArrayList;
    }
}
