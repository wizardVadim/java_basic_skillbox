public class Transfer implements Runnable {

    private Bank bank;
    private String fromAccountNum;
    private String toAccountNum;
    private long money;
    private volatile boolean isRunning = true;

    public Transfer(Bank bank, String fromAccountNum, String toAccountNum, long money) {
        this.bank = bank;
        this.fromAccountNum = fromAccountNum;
        this.toAccountNum = toAccountNum;
        this.money = money;
    }

    @Override
    public void run() {
        if (!fromAccountNum.equals(toAccountNum)) {
            if (isRunning) {
                bank.transfer(fromAccountNum, toAccountNum, money);
                System.out.println(bank.getBalance(fromAccountNum));
                System.out.println(bank.getBalance(toAccountNum));
            } else {
                System.out.println("Программа завершила работу");
            }
        } else {
            System.out.println("Указанные счета одинаковы");
        }
    }

    public void stop() {
        isRunning = false;
    }
}
