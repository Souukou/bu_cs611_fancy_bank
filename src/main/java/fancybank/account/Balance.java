package fancybank.account;

public class Balance {
    double balance;

    public Balance() {
        this.balance = 0;
    }

    public Balance(double balance) {
        if (balance < 0) {
            this.balance = 0;
            return;
        }
        this.balance = balance;
    }

    public double get() {
        return balance;
    }

    public void set(double balance) {
        if (balance < 0) {
            return;
        }
        this.balance = balance;
    }

    public void add(double amount) {
        if (amount < 0) {
            return;
        }
        this.balance += amount;
    }


    public void subtract(double amount) {
        if (amount < 0) {
            return;
        }
        if (!isSufficient(amount)) {
            return;
        }
        this.balance -= amount;
    }

    public boolean isSufficient(double amount) {
        return this.balance >= amount;
    }

    public String toString() {
        return String.format("%.2f", balance);
    }

}
