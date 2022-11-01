import java.util.*;

public class Main {

    public static final String STAFF_TXT = "data/staff.txt";

    public static void main(String[] args) {
        List<Employee> staff = Employee.loadStaffFromFile(STAFF_TXT);
        System.out.println(staff);
        sortBySalaryAndAlphabet(staff);
    }

    public static void sortBySalaryAndAlphabet(List<Employee> staff) {


        Collections.sort(staff, (o1, o2) -> {
            return o1.getName().compareTo(o2.getName());
        });
        Collections.sort(staff, (o1, o2) -> {
            return o1.getSalary().compareTo(o2.getSalary());
        });
        System.out.println(staff);
    }
}