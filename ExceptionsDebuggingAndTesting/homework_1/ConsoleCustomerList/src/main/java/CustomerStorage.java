import java.util.HashMap;
import java.util.Map;

public class CustomerStorage {
    private final Map<String, Customer> storage;

    public CustomerStorage() {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) {
        final int INDEX_NAME = 0;
        final int INDEX_SURNAME = 1;
        final int INDEX_EMAIL = 2;
        final int INDEX_PHONE = 3;

        String[] components = data.split("\\s+");
        if (components.length != 4) {
            throw new IllegalArgumentException("Wrong format: wrong Incorrect amount of data." +
                    "Format:\n" + "add Василий Петров vasily.petrov@gmail.com +79215637722");
        }
        if (checkFormatNumber(components[INDEX_PHONE])) {
            throw new IllegalArgumentException("Wrong format: wrong format phone number." +
                    "Format:\n" + "+7XXXXXXXXXX");
        }
        if (checkFormatEmail(components[INDEX_EMAIL])) {
            throw new IllegalArgumentException("Wrong format: wrong format email address." +
                    "Format:\n" + "vasily.petrov@gmail.com");
        }
        String name = components[INDEX_NAME] + " " + components[INDEX_SURNAME];
        storage.put(name, new Customer(name, components[INDEX_PHONE], components[INDEX_EMAIL]));
    }

    private boolean checkFormatNumber(String number) {
        String formatNumber = "[+][7][0-9]{10}";
        if (number.matches(formatNumber)) {
            return false;
        } else {
            return true;
        }

    }

    private boolean checkFormatEmail(String email) {
        String formatEmail = "[A-z.]+[@][a-z]+[.][a-z]{1,3}";
        if (email.matches(formatEmail)) {
            return false;
        } else {
            return true;
        }
    }

    public void listCustomers() {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name) {
        storage.remove(name);
    }

    public Customer getCustomer(String name) {
        return storage.get(name);
    }

    public int getCount() {
        return storage.size();
    }
}