package fancybank.account;

public abstract class Account {
    private int accountNumber;
    private Balance balance;
    private String accountType;

    public Account() {
    }

    public Account(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Account(int accountNumber, String accountType) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = new Balance();
    }

    public Account(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = new Balance(balance);
    }

    public Account(int accountNumber, String accountType, double balance) {
        this.accountNumber = accountNumber;
        this.balance = new Balance(balance);
        this.accountType = accountType;
    }


    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Balance getBalance() {
        return balance;
    }

    public void setBalance(Balance balance) {
        this.balance = balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

}
