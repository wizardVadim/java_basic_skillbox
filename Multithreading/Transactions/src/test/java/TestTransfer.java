import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Scanner;

public class TestTransfer extends TestCase {
    ArrayList<Thread> threads = new ArrayList<>();
    Bank bank = new Bank();
    int valueOfThreads = 100000;
    int valueOfAccounts = 2;
    long startMoney = 100000;

    @Override
    protected void setUp() throws Exception {
        for (int i = 0; i < valueOfAccounts; i++) {
            bank.addAccount(String.valueOf(i), startMoney);
        }
    }

    public void testTransfer() {
        Transfer transfer = null;
        for (int i = 0; i < valueOfThreads; i++) {

            String acc1 = bank.getAccNumber(getRandomIndex(valueOfAccounts));
            String acc2 = bank.getAccNumber(getRandomIndex(valueOfAccounts));

            transfer = new Transfer(bank, acc1, acc2, getRandomValueOfMoney());

            threads.add(new Thread(transfer));
        }

        threads.forEach(thread -> thread.start());


        try {
            threads.get(threads.size() - 1).join();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        transfer.stop();

        assertEquals(startMoney * valueOfAccounts, bank.getSumAllAccounts());



    }

    public static int getRandomIndex(int valueOfAccounts) {
        int value = (int) Math.round(Math.random() * (valueOfAccounts - 1));
        return value;
    }

    private static long getRandomValueOfMoney() {
        long value = 0;
        if (getProbability() != 19) {
            value = Math.round(Math.random() * 49999);
        } else if (getProbability() == 19) {
            value = 50000 + (int) Math.round(Math.random());
        }
        return value;
    }

    private static int getProbability() {
        int probability = (int) Math.round(Math.random() * 19);
        return probability;
    }
}
