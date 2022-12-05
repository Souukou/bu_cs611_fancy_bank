package fancybank.data;

import fancybank.account.Account;

/**
 * @author Haodong Chen hjc5283@bu.edu
 * Class for store and manage accounts. 
 */
public class AccountManager {
    
    private Account[] accounts;

    public Account[] getAccounts() { return accounts; }

    public boolean addAccount(Account account) {
        Account[] accountsNew = new Account[accounts.length + 1];
        for(int i = 0; i < accounts.length; i ++) {
            if(accounts[i].getId() == account.getId()) return false;
            accountsNew[i] = accounts[i];
        }
        accountsNew[accounts.length] = account;
        return true;
    }

}
