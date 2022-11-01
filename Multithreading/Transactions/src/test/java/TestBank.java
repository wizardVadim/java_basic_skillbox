import junit.framework.TestCase;

public class TestBank extends TestCase {

    Bank bank = new Bank();

    public void testTransfer() {
        bank.addAccount("2210998916473467", 20000);
        bank.addAccount("2210864582650390", 1000);
        bank.transfer("2210998916473467", "2210864582650390", 10000);

        assertEquals(11000, bank.getAccount("2210864582650390").getMoney());
    }

    public void testGetSumAllAccounts() {
        bank.addAccount("2210998916473467", 20000);
        bank.addAccount("2210864582650390", 1000);
        bank.addAccount("2210262382680391", 15000);
        bank.transfer("2210998916473467", "2210864582650390", 10000);
        assertEquals(36000, bank.getSumAllAccounts());

    }

    @Override
    protected void setUp() throws Exception {
    }

    @Override
    protected void tearDown() throws Exception {
    }
}
