package fancybank.data;

import java.util.ArrayList;
import java.util.Arrays;

import com.google.gson.Gson;

import fancybank.account.Account;
import fancybank.bank.Bank;
import fancybank.currency.Currency;
import fancybank.data.Handlers.CurrencyHandler;
import fancybank.data.Handlers.CustomerHandler;
import fancybank.data.Handlers.ManagerHandler;
import fancybank.data.Handlers.SimulateTime;
import fancybank.data.Handlers.TransactionHandler;
import fancybank.stock.Stock;
import fancybank.stock.StockMarket;
import fancybank.transaction.Transaction;
import fancybank.user.Address;
import fancybank.user.Customer;
import fancybank.user.Email;
import fancybank.user.Manager;
import fancybank.user.Name;
import fancybank.user.Password;
import fancybank.user.UID;
import fancybank.user.Username;

/**
 * @author Haodong Chen hjc5283@bu.edu
 *         Class for store and read data.
 */
public class Data implements ReadJsonFile, WriteJsonFile {

    private static Data instance;

    public static Data getInstance() {
        if (instance == null) instance = new Data();
        return instance;
    }

    private Gson gson = new Gson();
    private CustomerHandler customers;
    private ManagerHandler managers;
    private TransactionHandler trans;
    private StockMarket market;
    private CurrencyHandler currencies;
    private SimulateTime time;
    private Bank bank;

    public Data() {
        String jsonStr;

        jsonStr = ReadJsonFile.readFile(DataFile.CUSTOMER.getPath());
        if(jsonStr == null) this.customers = new CustomerHandler();
        else this.customers = gson.fromJson(jsonStr, CustomerHandler.class);

        jsonStr = ReadJsonFile.readFile(DataFile.MANAGER.getPath());
        if(jsonStr == null) this.managers = new ManagerHandler();
        else this.managers = gson.fromJson(jsonStr, ManagerHandler.class);

        jsonStr = ReadJsonFile.readFile(DataFile.TRANSACTION.getPath());
        if(jsonStr == null) this.trans = new TransactionHandler();
        else this.trans = gson.fromJson(jsonStr, TransactionHandler.class);

        jsonStr = ReadJsonFile.readFile(DataFile.STOCKMARKET.getPath());
        if (jsonStr == null) {
            this.market = new StockMarket();
            market.getStockList().add(new Stock("AAPL", "Apple", 10.99));
            market.getStockList().add(new Stock("GOOG", "Google", 18.88));
            market.getStockList().add(new Stock("MSFT", "Microsoft", 20.05));
            market.getStockList().add(new Stock("AMZN", "Amazon", 8.99));
            market.getStockList().add(new Stock("FB", "Facebook", 400));
            market.getStockList().add(new Stock("TSLA", "Tesla", 500));
            market.getStockList().add(new Stock("NFLX", "Netflix", 600));
            market.getStockList().add(new Stock("NVDA", "Nvidia", 700));
            market.getStockList().add(new Stock("PYPL", "PayPal", 800));
            market.getStockList().add(new Stock("INTC", "Intel", 900));
            market.getStockList().add(new Stock("CSCO", "Cisco", 1000));
            market.getStockList().add(new Stock("QCOM", "Qualcomm", 1100));
            market.getStockList().add(new Stock("TXN", "Texas Instruments", 1200));
            market.getStockList().add(new Stock("ADBE", "Adobe", 1300));
            market.getStockList().add(new Stock("CRM", "Salesforce", 1400));
            market.getStockList().add(new Stock("AVGO", "Broadcom", 1500));
            market.getStockList().add(new Stock("COST", "Costco", 1600));
            market.getStockList().add(new Stock("SBUX", "Starbucks", 1700));
            market.getStockList().add(new Stock("CMCSA", "Comcast", 1800));
            market.getStockList().add(new Stock("AMGN", "Amgen", 1900));
            market.getStockList().add(new Stock("CHTR", "Charter", 2000));
            market.getStockList().add(new Stock("GILD", "Gilead", 2100));
            market.getStockList().add(new Stock("MDLZ", "Mondelez", 2200));
            market.getStockList().add(new Stock("ISRG", "Intuitive Surgical", 2300));
            market.getStockList().add(new Stock("TMUS", "T-Mobile", 2400));
            market.getStockList().add(new Stock("AMAT", "Applied Materials", 2500));
            market.getStockList().add(new Stock("AMD", "AMD", 2600));
            market.getStockList().add(new Stock("MU", "Micron", 2700));
        }

        else
            this.market = gson.fromJson(jsonStr, StockMarket.class);

        jsonStr = ReadJsonFile.readFile(DataFile.SIMULATETIME.getPath());
        if(jsonStr == null) this.time = new SimulateTime();
        else this.time = gson.fromJson(jsonStr, SimulateTime.class);


        jsonStr = ReadJsonFile.readFile(DataFile.BANK.getPath());
        if (jsonStr == null)
            this.bank = new Bank();
        else
            this.bank = gson.fromJson(jsonStr, Bank.class);
    }

    public Bank getBank() {
        return this.bank;
    }

    public void updateBank(Bank bank) {
        this.bank = bank;
        WriteJsonFile.writeFile(DataFile.BANK.getPath(), gson.toJson(bank));
    }

    public Customer getCustomerByUsername(Username username, String pw) {
        for (Customer c : this.customers.getCustomers()) {
            if (c.getUsername().get().equals(username.get()) && c.getPassword().validate(pw))
                return c;
        }
        return null;
    }

    public Customer getCustomerByUid(UID id, String pw) {
        for(Customer c : this.customers.getCustomers()) {
            if(c.getUID().get() == id.get() && c.getPassword().validate(pw))
                return c;
        }
        return null;
    }

    public Transaction[] getTransactionByAccount(int id) {
        ArrayList<Transaction> accountTransactions = new ArrayList<Transaction>();
        for(Transaction tran : this.trans.getTransactions()) {
            if (tran.getFrom() == id || tran.getTo() == id) accountTransactions.add(tran);
        }
        return accountTransactions.toArray(new Transaction[0]);
    }

    public Manager getManagerByUid(UID id, String pw) {
        for(Manager m : this.managers.getManagers()) {
            if(m.getUID().get() == id.get() && m.getPassword().validate(pw))
                return m;
        }
        return null;
    }

    public ArrayList<Manager> getManagers() {
        return new ArrayList<Manager>(Arrays.asList(this.managers.getManagers()));
    }

    public Manager getManagerByUsername(Username username, String pw) {
        for (Manager m : this.managers.getManagers()) {
            if (m.getUsername().get().equals(username.get()) && m.getPassword().validate(pw))
                return m;
        }
        return null;
    }

    public StockMarket getStockMarket() {
        return this.market;
    }

    public SimulateTime getTime() {
        return this.time;
    }

    /**
     * Update info of a single customer in the database.
     * @param c The customer to be updated.
     * @return Whether the customer has been found in the database.
     */
    public boolean updateCustomer(Customer c) {
        for (Customer e : this.customers.getCustomers()) {
            if (e.getUID().get() == c.getUID().get()) {
                e = c;
                return true;
            }
        }
        WriteJsonFile.writeFile(DataFile.CUSTOMER.getPath(), gson.toJson(customers));
        return false;
    }

    public Customer addCustomer(Username username, Name name, Address address, Email email, Password password) {
        Customer customerNew = this.customers.addCustomer(username, name, address, email, password);
        WriteJsonFile.writeFile(DataFile.CUSTOMER.getPath(), gson.toJson(customers));
        return customerNew;
    }

    /**
     * Update info of a single manager in the database.
     * @param m The manager to be updated.
     * @return Whether the manager has been found in the database.
     */
    public boolean updateManager(Manager m) {
        for(Manager e : this.managers.getManagers()) {
            if (e.getUID().get() == m.getUID().get()) {
                e = m;
                return true;
            }
        }
        WriteJsonFile.writeFile(DataFile.MANAGER.getPath(), gson.toJson(managers));
        return false;
    }

    public Manager addManager(Username username, Name name, Address address, Email email, Password password) {
        Manager managerNew = this.managers.addManager(username, name, address, email, password);
        WriteJsonFile.writeFile(DataFile.MANAGER.getPath(), gson.toJson(managers));
        return managerNew;
    }

    public void addTransaction(Transaction e) {
        this.trans.addTransaction(e);
        WriteJsonFile.writeFile(DataFile.TRANSACTION.getPath(), gson.toJson(trans));
    }

    public void updateStockMarket(StockMarket market) {
        this.market = market;
        WriteJsonFile.writeFile(DataFile.STOCKMARKET.getPath(), gson.toJson(market));
    }

    public void addDays(int days) {
        this.time.addDay(days);
        WriteJsonFile.writeFile(DataFile.SIMULATETIME.getPath(), gson.toJson(time));
    }

    public int getNextAccountNumber() {
        int maxAccountNumber = 200000; // accouunt number start from 200000
        for(Customer c: customers.getCustomers()) {
            for(Account acct: c.getAccounts()) {
                maxAccountNumber = (maxAccountNumber > acct.getAccountNumber() ? maxAccountNumber : acct.getAccountNumber());
            }
        }
        return maxAccountNumber + 1;
    }

    public ArrayList<Currency> getCurrencyList() {
        return currencies.getCurrencies();
    }

    public void updateCurrencyList(ArrayList<Currency> currencyList) {
        currencies.setCurrencies(currencyList);
        WriteJsonFile.writeFile(DataFile.CURRENCY.getPath(), gson.toJson(currencies));
    }

}
