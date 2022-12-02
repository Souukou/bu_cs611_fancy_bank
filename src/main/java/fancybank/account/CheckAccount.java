package fancybank.account;

public class CheckAccount extends Account {
    private double balance;

    public CheckAccount() {
    }

    public CheckAccount(int accountNumber) {
        super(accountNumber);
        this.balance = 0;
    }

    public CheckAccount(int accountNumber, double balance) {
        super(accountNumber);
        this.setBalance(balance);
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if (balance < 0) {
            return;
        }
        this.balance = balance;
    }
}
