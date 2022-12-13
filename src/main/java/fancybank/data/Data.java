package fancybank.data;

import fancybank.account.Account;
import fancybank.user.Customer;

public class Data {
    public static Data instance = new Data();

    private Data() {
    }

    public static Data getInstance() {
        return instance;
    }

    private int TEMP_accountNumber = 10001; /// test only. should be read from db

    public int getMaxAccountNumber() {
        TEMP_accountNumber += 15; /// test only
        return TEMP_accountNumber;
    }

    public void saveAccount(Customer cos, Account accont) {
    }

    public void AddTransaction(Account from, Account to, double amount, String memo) {

    }

}
