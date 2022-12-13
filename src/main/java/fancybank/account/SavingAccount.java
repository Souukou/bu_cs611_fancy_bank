package fancybank.account;

public class SavingAccount extends Account implements CashOperable, Transferable {
    SavingAccount() {
        super(0, "Saving", 0);
    }

    SavingAccount(int accountNumber) {
        super(accountNumber, "Saving", 0);
    }

    SavingAccount(int accountNumber, double balance) {
        super(accountNumber, "Saving", balance);
    }

    @Override
    public void deposit(double amount) {
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
