package fancybank.account;

public class CheckAccount extends Account implements CashOperable, Transferable {

    public CheckAccount() {
        super(0, "Check", 0);
    }

    public CheckAccount(int accountNumber) {
        super(accountNumber, "Check", 0);
    }

    public CheckAccount(int accountNumber, double balance) {
        super(accountNumber, "Check", balance);

    }

    public void setBalance(double balance) {
        getBalance().set(balance);
    }

    @Override
    public void deposit(double amount) {
        if (amount < 0) {
            return;
        }
        getBalance().add(amount);
    }

    @Override
    public void withdraw(double amount) {
        getBalance().subtract(amount);
    }

    @Override
    public void transferTo(Account target, double amount) {
        if (amount < 0) {
            return;
        }
        if (!getBalance().isSufficient(amount)) {
            return;
        }
        getBalance().subtract(amount);
        target.getBalance().add(amount);
    }
}
