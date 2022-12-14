package fancybank.account;

public class CheckAccount extends Account implements CashOperable, Transferable, Exchangeable {

    public CheckAccount() {
        super(0, "checking", 0, "USD");
    }

    public CheckAccount(int accountNumber) {
        super(accountNumber, "checking", 0, "USD");
    }

    public CheckAccount(int accountNumber, double balance, String currency) {
        super(accountNumber, "checking", balance, currency);

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

    @Override
    public boolean exchangeTo(Account targetAccount, Balance exBalance) {
        if (!(targetAccount instanceof Exchangeable)) {
            return false;
        }
        if (exBalance.get() < 0) {
            return false;
        }
        if (!getBalance().isSufficient(exBalance)) {
            return false;
        }
        this.getBalance().subtract(exBalance);
        targetAccount.getBalance().add(exBalance);
        return true;
    }
}
