package fancybank.data;

import java.util.ArrayList;

import com.google.gson.Gson;

import fancybank.data.Handlers.CustomerHandler;
import fancybank.data.Handlers.ManagerHandler;
import fancybank.data.Handlers.SimulateTime;
import fancybank.data.Handlers.TransactionHandler;
import fancybank.stock.StockMarket;
import fancybank.transaction.Transaction;
import fancybank.user.Address;
import fancybank.user.Customer;
import fancybank.user.Email;
import fancybank.user.Manager;
import fancybank.user.Name;
import fancybank.user.Password;
import fancybank.user.UID;

/**
 * @author Haodong Chen hjc5283@bu.edu
 * Class for store and read data. 
 */
public class Data implements ReadJsonFile, WriteJsonFile {

    private static Gson gson = new Gson();
    private static CustomerHandler customers;
    private static ManagerHandler managers;
    private static TransactionHandler trans;
    private static StockMarket stocks;
    private static SimulateTime time;

    static {
        String jsonStr;
        jsonStr = ReadJsonFile.readFile(DataFile.CUSTOMER.getPath());
        if(jsonStr == null) customers = new CustomerHandler();
        else customers = gson.fromJson(jsonStr, CustomerHandler.class);

        jsonStr = ReadJsonFile.readFile(DataFile.MANAGER.getPath());
        if(jsonStr == null) managers = new ManagerHandler();
        else managers = gson.fromJson(jsonStr, ManagerHandler.class);

        jsonStr = ReadJsonFile.readFile(DataFile.TRANSACTION.getPath());
        if(jsonStr == null) trans = new TransactionHandler();
        else trans = gson.fromJson(jsonStr, TransactionHandler.class);

        jsonStr = ReadJsonFile.readFile(DataFile.STOCKMARKET.getPath());
        if(jsonStr == null) stocks = StockMarket.getInstance();
        else stocks = gson.fromJson(jsonStr, StockMarket.class);

        jsonStr = ReadJsonFile.readFile(DataFile.SIMULATETIME.getPath());
        if(jsonStr == null) time = new SimulateTime();
        else time = gson.fromJson(jsonStr, SimulateTime.class);

    }

    public static Customer getCustomerByUid(UID id, String pw) {
        for(Customer c: customers.getCustomers()) {
            if(c.getUID().get() == id.get() && c.getPassword().validate(pw)) return c;
        }
        return null;
    }

    public static Transaction[] geTransactionByAccount(int id) {
        ArrayList<Transaction> accountTransactions = new ArrayList<Transaction>();
        for(Transaction tran: trans.getTransactions()) {
            if(tran.getFrom() == id || tran.getTo() == id) accountTransactions.add(tran);
        }
        return accountTransactions.toArray(new Transaction[0]);
    }

    public static Manager getManagerByUid(UID id, String pw) {
        for(Manager m: managers.getManagers()) {
            if(m.getUID().get() == id.get() && m.getPassword().validate(pw)) return m;
        }
        return null;
    }

    public static StockMarket getStockMarket() {
        return stocks;
    }

    public static SimulateTime getTime() {
        return time;
    }

    /**
     * Update info of a single customer in the database.
     * @param c The customer to be updated.
     * @return Whether the customer has been found in the database.
     */
    public static boolean updateCustomer(Customer c) {
        for(Customer e: customers.getCustomers()) {
            if(e.getUID().get() == c.getUID().get()) {
                e = c;
                return true;
            }
        }
        return false;
    }

    public static Customer addCustomer(Name name, Address address, Email email, Password password) {
        Customer customerNew = customers.addCustomer(name, address, email, password);
        WriteJsonFile.writeFile(DataFile.CUSTOMER.getPath(), gson.toJson(customers));
        return customerNew;
    }

    /**
     * Update info of a single manager in the database.
     * @param m The manager to be updated.
     * @return Whether the manager has been found in the database.
     */
    public static boolean updateManager(Manager m) {
        for(Manager e: managers.getManagers()) {
            if(e.getUID().get() == m.getUID().get()) {
                e = m;
                return true;
            }
        }
        return false;
    }

    public static Manager addManager(Name name, Address address, Email email, Password password) {
        Manager managerNew = managers.addManager(name, address, email, password);
        WriteJsonFile.writeFile(DataFile.MANAGER.getPath(), gson.toJson(managers));
        return managerNew;
    }

    public static void AddTransaction(Transaction e) {
        trans.addTransaction(e);
        WriteJsonFile.writeFile(DataFile.TRANSACTION.getPath(), gson.toJson(trans));
    }

    public static void updateStocks(StockMarket market) {
        stocks = market;
        WriteJsonFile.writeFile(DataFile.STOCKMARKET.getPath(), gson.toJson(stocks));
    }

    public static void addDays(int days) {
        time.addDay(days);
        WriteJsonFile.writeFile(DataFile.SIMULATETIME.getPath(), gson.toJson(time));
    }

}
