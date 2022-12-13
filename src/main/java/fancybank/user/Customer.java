package fancybank.user;

import java.util.ArrayList;

import fancybank.account.Account;
import fancybank.account.CheckAccount;
import fancybank.account.SavingAccount;
import fancybank.account.SecurityAccount;
import fancybank.account.Transferable;
import fancybank.data.Data;

public class Customer extends User {
    ArrayList<Account> accounts;

    public Customer() {
        super();
        this.accounts = new ArrayList<Account>();
    }

    public Customer(UID UID, Name name, Address address, Email email, Password password) {
        super(UID, name, address, email, password);
        this.accounts = new ArrayList<Account>();
    }

    public Customer(UID UID, Name name, Address address, Email email, Password password, ArrayList<Account> accounts) {
        super(UID, name, address, email, password);
        this.accounts = accounts;
    }

    public Customer(int uid, String firstName, String middleName, String lastName, String street, String city, String state, String zip, String country, String email, Password password) {
        super(uid, firstName, middleName, lastName, street, city, state, zip, country, email, password);
        this.accounts = new ArrayList<Account>();
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
        return "Customer [UID=" + getUID() + ", name=" + getName() + ", address=" + getAddress() + ", email=" + getEmail() + "]";
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

    public void createAccount(String type, double balance) {
        Account account = null;
        int nextAccountNumber = Data.getInstance().getMaxAccountNumber() + 1;

        if (type.equals("checking")) {
            account = new CheckAccount(nextAccountNumber, balance);
        } else if (type.equals("saving")) {
            account = new SavingAccount(nextAccountNumber, balance);
        } else if (type.equals("security")) {
            account = new SecurityAccount(nextAccountNumber, balance);
        }
        if (account != null) {
            this.accounts.add(account);
        }
        Data.getInstance().saveAccount(this, account);
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
        from.getBalance().subtract(amount);
        to.getBalance().add(amount);
        Data.getInstance().AddTransaction(from, to, amount, memo);
        return true;
    }

    public boolean Transfer(Account from, Account to, double amount) {
        return Transfer(from, to, amount, "");
    }
}
