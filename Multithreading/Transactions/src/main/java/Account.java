public class Account {

    public Account(String accNumber) {
        this.accNumber = accNumber;
        money = -200; // priceForMakingAcc
    }

    public Account(String accNumber, long money) {
        this.accNumber = accNumber;
        this.money = money;
    }

    private long money;
    private String accNumber;

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    public String getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(String accNumber) {
        this.accNumber = accNumber;
    }
}
