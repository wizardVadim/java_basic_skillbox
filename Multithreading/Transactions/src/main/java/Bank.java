import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public class Bank {

    private ArrayList<String> accNumbers = new ArrayList<>();
    private HashSet<String> blackList = new HashSet<>();
    private HashMap<String, Account> accounts = new HashMap<>();
    private final Random random = new Random();

    public synchronized boolean isFraud(String fromAccountNum, String toAccountNum, long amount)
        throws InterruptedException {
        Thread.sleep(1000);
        return random.nextBoolean();
    }

    /**
     * TODO: реализовать метод. Метод переводит деньги между счетами. Если сумма транзакции > 50000,
     * то после совершения транзакции, она отправляется на проверку Службе Безопасности – вызывается
     * метод isFraud. Если возвращается true, то делается блокировка счетов (как – на ваше
     * усмотрение)
     */
    public void transfer(String fromAccountNum, String toAccountNum, long amount) {

        if(!blackList.contains(fromAccountNum) && !blackList.contains(toAccountNum)) {

            if (!isAccountFromMap(fromAccountNum)) {
                addAccount(fromAccountNum);
            }

            if (!isAccountFromMap(toAccountNum)) {
                addAccount(toAccountNum);
            }

            Account account1 = accounts.get(fromAccountNum);
            Account account2 = accounts.get(toAccountNum);

            int fromId = Integer.parseInt(account1.getAccNumber());
            int toId = Integer.parseInt(account2.getAccNumber());

            if (fromId > toId) {
                synchronized (account1) {
                    synchronized (account2) {
                        checkAndSend(account1, account2, amount);
                    }
                }
            } else {
                synchronized (account2) {
                    synchronized (account1) {
                        checkAndSend(account1, account2, amount);
                    }
                }
            }
        } else {
            System.out.println("Какой-то из счетов в черном списке");
        }
    }

    /**
     * TODO: реализовать метод. Возвращает остаток на счёте.
     */
    public long getBalance(String accountNum) {
        if(!isAccountFromMap(accountNum)){
            addAccount(accountNum);
        }
        return accounts.get(accountNum).getMoney();
    }

    public long getSumAllAccounts() {
        long sum = 0;
        for (String number : accNumbers) {
            sum += accounts.get(number).getMoney();
        }
        return sum;
    }

    private boolean isAccountFromMap(String accNumber) {
        boolean isAccountFromMap = false;
        if(accounts.containsKey(accNumber)) {
            isAccountFromMap = true;
        }
        return isAccountFromMap;
    }

    public void addAccount(String accNumber) {
        accounts.put(accNumber, new Account(accNumber));
        accNumbers.add(accNumber);
    }

    public void addAccount(String accNumber, long money) {
        accounts.put(accNumber, new Account(accNumber, money));
        accNumbers.add(accNumber);
    }

    public Account getAccount(String accNumber) {
        return accounts.get(accNumber);
    }

    public String getAccNumber(int i) {
        return accNumbers.get(i);
    }

    private void checkAndSend(Account fromAccount, Account toAccount, long amount) {

        if (amount > 50000) {
            try {
                if (isFraud(fromAccount.getAccNumber(), toAccount.getAccNumber(), amount)) {
                    blackList.add(fromAccount.getAccNumber());
                    blackList.add(toAccount.getAccNumber());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        } else if (fromAccount.getMoney() >= amount) {
            toAccount.setMoney(toAccount.getMoney() + amount);
            fromAccount.setMoney(fromAccount.getMoney() - amount);
        } else {
            System.out.println("Недостаточно средств на счету");
        }
    }
}
