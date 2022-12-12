package fancybank.account;

public class CheckAccount extends Account implements CashOperable {

    public CheckAccount() {
        super(0, "Check");
    }

    public CheckAccount(int accountNumber) {
        super(accountNumber, "Check");
    }

    public CheckAccount(int accountNumber, double balance) {
        super(accountNumber, "Check");
        setBalance(balance);

    }

    public void setBalance(double balance) {
        // check account balance cannot be negative
        if (balance < 0) {
            return;
        }
        super.setBalance(balance);
    }

    @Override
    public void deposit(double amount) {
        if (amount < 0) {
            return;
        }
        setBalance(getBalance() + amount);
    }

    @Override
    public void withdraw(double amount) {
        if (amount < 0) {
            return;
        }
        setBalance(getBalance() - amount);
    }

}
