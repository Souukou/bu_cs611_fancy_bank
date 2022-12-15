package fancybank.user;

import java.util.ArrayList;

import fancybank.account.Account;
import fancybank.account.Balance;
import fancybank.account.CheckAccount;
import fancybank.account.SavingAccount;
import fancybank.account.SecurityAccount;
import fancybank.account.Transferable;
import fancybank.bank.Bank;
import fancybank.data.Data;
import fancybank.loan.Collateral;
import fancybank.loan.Loan;
import fancybank.transaction.Transaction;

public class Customer extends User {
    ArrayList<Account> accounts;
    ArrayList<Loan> loans;

    public ArrayList<Loan> getLoans() {
        return loans;
    }

    public void borrowLoan(Account account, double amount, Collateral collateral) {
        double interestRate = Bank.getInstance().getLoanInterestRate();
        Loan loan = new Loan(getUID(), account, amount, interestRate, collateral);
        loans.add(loan);
    }

    public Customer() {
        super();
        this.accounts = new ArrayList<Account>();
        this.loans = new ArrayList<Loan>();
    }

    public Customer(UID UID, Username username, Name name, Address address, Email email, Password password) {
        super(UID, username, name, address, email, password);
        this.accounts = new ArrayList<Account>();
        this.loans = new ArrayList<Loan>();
    }

    public Customer(UID UID, Username username, Name name, Address address, Email email, Password password,
            ArrayList<Account> accounts) {
        super(UID, username, name, address, email, password);
        this.accounts = accounts;
        this.loans = new ArrayList<Loan>();
    }

    public Customer(int uid, String username, String firstName, String middleName, String lastName, String street,
            String city, String state, String zip, String country, String email, String password) {
        super(uid, username, firstName, middleName, lastName, street, city, state, zip, country, email, password);
        this.accounts = new ArrayList<Account>();
        this.loans = new ArrayList<Loan>();
    }

    public void save() {
        Data.getInstance().updateCustomer(this);
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(ArrayList<Account> accounts) {
        this.accounts = accounts;
    }

    public void addAccount(Account account) {
        this.accounts.add(account);
    }

    public void removeAccount(Account account) {
        this.accounts.remove(account);
    }

    public String toString() {
        return "Customer [UID=" + getUID() + "username=" + getUsername() + ", name=" + getName() + ", address="
                + getAddress() + ", email=" + getEmail() + "]";
    }

    public ArrayList<CheckAccount> getCheckAccount() {
        ArrayList<CheckAccount> checkAccounts = new ArrayList<CheckAccount>();
        for (Account account : accounts) {
            if (account instanceof CheckAccount) {
                checkAccounts.add((CheckAccount) account);
            }
        }
        return checkAccounts;
    }

    public ArrayList<SavingAccount> getSavingAccount() {
        ArrayList<SavingAccount> savingAccounts = new ArrayList<SavingAccount>();
        for (Account account : accounts) {
            if (account instanceof SavingAccount) {
                savingAccounts.add((SavingAccount) account);
            }
        }
        return savingAccounts;
    }

    public ArrayList<SecurityAccount> getSecurityAccounts() {
        ArrayList<SecurityAccount> securityAccounts = new ArrayList<SecurityAccount>();
        for (Account account : accounts) {
            if (account instanceof SecurityAccount) {
                securityAccounts.add((SecurityAccount) account);
            }
        }
        return securityAccounts;
    }

    public ArrayList<Account> getAccountByCurrency(String currency) {
        ArrayList<Account> accounts = new ArrayList<Account>();
        for (Account account : this.accounts) {
            if (account.getBalance().getCurrency().getName().equals(currency)) {
                accounts.add(account);
            }
        }
        return accounts;
    }

    // if only have one check accont, use this
    public CheckAccount getOneCheckAccount() {
        ArrayList<CheckAccount> checkAccounts = getCheckAccount();
        if (checkAccounts.size() >= 1) {
            return checkAccounts.get(0);
        }
        return null;
    }

    // if only have one saving accont, use this
    public SavingAccount getOneSavingAccount() {
        ArrayList<SavingAccount> savingAccount = getSavingAccount();
        if (savingAccount.size() >= 1) {
            return savingAccount.get(0);
        }
        return null;
    }

    // if only have one security accont, use this
    public SecurityAccount getOneSecurityAccount() {
        ArrayList<SecurityAccount> securityAccounts = getSecurityAccounts();
        if (securityAccounts.size() >= 1) {
            return securityAccounts.get(0);
        }
        return null;
    }

    // if only one currency per account, use this
    public Account getOneAccountByCurrency(String currency) {
        ArrayList<Account> accounts = getAccountByCurrency(currency);
        if (accounts.size() >= 1) {
            return accounts.get(0);
        }
        return null;
    }

    public void createAccount(String type, double balance, String currency) {
        Account account = null;
        int nextAccountNumber = Data.getInstance().getNextAccountNumber();

        if (type.equals("checking")) {
            account = new CheckAccount(nextAccountNumber, balance, currency);
        } else if (type.equals("saving")) {
            account = new SavingAccount(nextAccountNumber, balance, currency);
        } else if (type.equals("security")) {
            account = new SecurityAccount(nextAccountNumber, balance);
        }
        if (account != null) {
            this.accounts.add(account);
        }
        this.save();
    }

    public ArrayList<Account> getCurrancyAccountList(String currency) {
        ArrayList<Account> currencyAccountList = new ArrayList<Account>();
        for (Account account : accounts) {
            if (account.getBalance().getCurrency().getName().equals(currency)) {
                currencyAccountList.add(account);
            }
        }
        return currencyAccountList;
    }

    public boolean createCheckAccount(double balance, String currency) {
        // our logic is to limit one checking account per currency
        ArrayList<Account> currencyAccountList = getCurrancyAccountList(currency);
        for (Account account : currencyAccountList) {
            if (account instanceof CheckAccount) {
                return false;
            }
        }
        // create account
        createAccount("checking", balance, currency);
        return true;
    }

    public boolean createSavingAccount(double balance, String currency) {
        // our logic is to limit one checking account per currency
        ArrayList<Account> currencyAccountList = getCurrancyAccountList(currency);
        for (Account account : currencyAccountList) {
            if (account instanceof SavingAccount) {
                return false;
            }
        }
        // create account
        createAccount("saving", balance, currency);
        return true;
    }

    public boolean createSecurityAccount(double balance) {
        // our logic is to limit one checking account
        ArrayList<SecurityAccount> securityAccountList = getSecurityAccounts();
        if (securityAccountList.size() >= 1) {
            return false;
        }
        // create account
        createAccount("security", balance, "USD");
        return true;
    }

    public boolean Transfer(Account from, Account to, double amount, String memo) {
        if (!(from instanceof Transferable)) {
            return false;
        }
        if (!(to instanceof Transferable)) {
            return false;
        }
        if (!from.getBalance().isSufficient(amount)) {
            return false;
        }
        Balance exchangeBalance = new Balance(amount, from.getBalance().getCurrency());
        from.getBalance().subtract(exchangeBalance);
        to.getBalance().add(exchangeBalance);
        // TODO: need transaction class
        // Data.getInstance().AddTransaction(from, to, exchangeBalance, memo);
        return true;
    }

    public boolean Transfer(Account from, Account to, double amount) {
        return Transfer(from, to, amount, "");
    }

    public boolean TransferSameCurrency(Account from, Account to, double amout, String memo) {
        if (from.getBalance().getCurrency().getName().equals(to.getBalance().getCurrency().getName())) {
            return Transfer(from, to, amout, memo);
        }
        return false;
    }

    public boolean TransferSameCurrency(Account from, Account to, double amout) {
        return TransferSameCurrency(from, to, amout, "");
    }

    public boolean ExchangeCurrency(Account from, Account to, Balance exchangeBalance) {
        if (!(from instanceof Transferable)) {
            return false;
        }
        if (!(to instanceof Transferable)) {
            return false;
        }
        if (!from.getBalance().isSufficient(exchangeBalance)) {
            return false;
        }
        from.getBalance().subtract(exchangeBalance);
        to.getBalance().add(exchangeBalance);
        // TODO: need transaction class
        // Data.getInstance().AddTransaction(new Transaction(from, to, exchangeBalance,
        // ""));
        return true;
    }
}
