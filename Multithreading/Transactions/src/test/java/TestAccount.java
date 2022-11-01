import junit.framework.TestCase;

public class TestAccount extends TestCase {

    Account account = new Account("2210120033110000", 10000);

    public void testGetAccNumber() {
        assertEquals("2210120033110000", account.getAccNumber());
    }

    public void testGetMoney() {
        assertEquals(10000, account.getMoney());
    }

    public void testSetMoney() {
        account.setMoney(1000);
        assertEquals(1000, account.getMoney());
    }

    public void testSetAccNumber() {
        account.setAccNumber("2210120033110001");
        assertEquals("2210120033110001", account.getAccNumber());
    }

    @Override
    protected void setUp() throws Exception {
    }

    @Override
    protected void tearDown() throws Exception {
    }
}
