package fancybank.account;

public class SavingAccount extends Account implements CashOperable {
    SavingAccount() {
        super(0, "Saving");
    }

    SavingAccount(int accountNumber) {
        super(accountNumber, "Saving");
    }

    SavingAccount(int accountNumber, double balance) {
        super(accountNumber, "Saving");
        setBalance(balance);
    }

    public void setBalance(double balance) {
        // saving account balance cannot be negative
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
