package fancybank.data;

import com.google.gson.Gson;
import java.util.concurrent.Semaphore;

/**
 * @author Haodong Chen hjc5283@bu.edu
 * Class for store and read data. 
 */
public class Data {

    Gson gson = new Gson();
    Semaphore accountSem = new Semaphore(1); 
    Semaphore transactionSem = new Semaphore(1);
    Semaphore userSem  = new Semaphore(1);
    Semaphore stockSem = new Semaphore(1);
    Semaphore timeSem = new Semaphore(1);

    // check for initialize
    static {
        //
    }
    
    public static Account getAccountById(int id) {
        AccountManager accounts = 
    }

    public static Account getAccountByUid(int uid) {
        //
    }

}
