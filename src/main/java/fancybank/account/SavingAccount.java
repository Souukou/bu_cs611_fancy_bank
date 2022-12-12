package fancybank.account;

public class SavingAccount extends Account {
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
}
