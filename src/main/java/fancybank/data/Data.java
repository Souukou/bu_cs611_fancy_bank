package fancybank.data;

import java.util.ArrayList;

import com.google.gson.Gson;

import fancybank.bank.Bank;
import fancybank.currency.Currency;
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
import fancybank.user.Username;

/**
 * @author Haodong Chen hjc5283@bu.edu
 *         Class for store and read data.
 */
public class Data implements ReadJsonFile, WriteJsonFile {

    private static Data instance;

    public static Data getInstance() {
        if (instance == null)
            instance = new Data();
        return instance;
    }

    private Gson gson = new Gson();
    private CustomerHandler customers;
    private ManagerHandler managers;
    private TransactionHandler trans;
    private StockMarket stocks;
    private SimulateTime time;
    private Bank bank;

    Data() {
        String jsonStr;
        jsonStr = ReadJsonFile.readFile(DataFile.CUSTOMER.getPath());
        if (jsonStr == null)
            this.customers = new CustomerHandler();
        else
            this.customers = gson.fromJson(jsonStr, CustomerHandler.class);

        jsonStr = ReadJsonFile.readFile(DataFile.MANAGER.getPath());
        if (jsonStr == null)
            this.managers = new ManagerHandler();
        else
            this.managers = gson.fromJson(jsonStr, ManagerHandler.class);

        jsonStr = ReadJsonFile.readFile(DataFile.TRANSACTION.getPath());
        if (jsonStr == null)
            this.trans = new TransactionHandler();
        else
            this.trans = gson.fromJson(jsonStr, TransactionHandler.class);

        jsonStr = ReadJsonFile.readFile(DataFile.STOCKMARKET.getPath());
        if (jsonStr == null)
            this.stocks = new StockMarket();
        else
            this.stocks = gson.fromJson(jsonStr, StockMarket.class);

        jsonStr = ReadJsonFile.readFile(DataFile.SIMULATETIME.getPath());
        if (jsonStr == null)
            this.time = new SimulateTime();
        else
            this.time = gson.fromJson(jsonStr, SimulateTime.class);

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
            if (c.getUsername().get().equals(username.get()))
                return c;
        }
        return null;
    }

    public Customer getCustomerByUid(UID id, String pw) {
        for (Customer c : this.customers.getCustomers()) {
            if (c.getUID().get() == id.get() && c.getPassword().validate(pw))
                return c;
        }
        return null;
    }

    public Transaction[] geTransactionByAccount(int id) {
        ArrayList<Transaction> accountTransactions = new ArrayList<Transaction>();
        for (Transaction tran : this.trans.getTransactions()) {
            if (tran.getFrom() == id || tran.getTo() == id)
                accountTransactions.add(tran);
        }
        return accountTransactions.toArray(new Transaction[0]);
    }

    public Manager getManagerByUid(UID id, String pw) {
        for (Manager m : this.managers.getManagers()) {
            if (m.getUID().get() == id.get() && m.getPassword().validate(pw))
                return m;
        }
        return null;
    }

    public StockMarket getStockMarket() {
        return this.stocks;
    }

    public SimulateTime getTime() {
        return this.time;
    }

    /**
     * Update info of a single customer in the database.
     * 
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
        return false;
    }

    public Customer addCustomer(Username username, Name name, Address address, Email email, Password password) {
        Customer customerNew = this.customers.addCustomer(username, name, address, email, password);
        WriteJsonFile.writeFile(DataFile.CUSTOMER.getPath(), gson.toJson(customers));
        return customerNew;
    }

    /**
     * Update info of a single manager in the database.
     * 
     * @param m The manager to be updated.
     * @return Whether the manager has been found in the database.
     */
    public boolean updateManager(Manager m) {
        for (Manager e : this.managers.getManagers()) {
            if (e.getUID().get() == m.getUID().get()) {
                e = m;
                return true;
            }
        }
        return false;
    }

    public Manager addManager(Username username, Name name, Address address, Email email, Password password) {
        Manager managerNew = this.managers.addManager(username, name, address, email, password);
        WriteJsonFile.writeFile(DataFile.MANAGER.getPath(), gson.toJson(managers));
        return managerNew;
    }

    public void AddTransaction(Transaction e) {
        this.trans.addTransaction(e);
        WriteJsonFile.writeFile(DataFile.TRANSACTION.getPath(), gson.toJson(trans));
    }

    public void updateStockMarket(StockMarket market) {
        this.stocks = market;
        WriteJsonFile.writeFile(DataFile.STOCKMARKET.getPath(), gson.toJson(stocks));
    }

    public void addDays(int days) {
        this.time.addDay(days);
        WriteJsonFile.writeFile(DataFile.SIMULATETIME.getPath(), gson.toJson(time));
    }

    public int getNextAccountNumber() {
        int maxAccountNumber = 200000; // accouunt number start from 200000
        for (Customer c : this.customers.getCustomers()) {
            maxAccountNumber = Math.max(maxAccountNumber, c.getAccounts().get(0).getAccountNumber());
        }
        return maxAccountNumber + 1;
    }

    // TODO @davidchd
    public ArrayList<Currency> getCurrencyList() {
        // read currency from db
        ArrayList<Currency> currencyList = new ArrayList<Currency>();
        currencyList.add(new Currency("USD", "$", 1.0));
        currencyList.add(new Currency("EUR", "€", 0.9));
        currencyList.add(new Currency("JPY", "¥", 110.0));
        currencyList.add(new Currency("GBP", "£", 0.8));
        currencyList.add(new Currency("AUD", "$", 1.4));
        currencyList.add(new Currency("CAD", "$", 1.3));
        currencyList.add(new Currency("CHF", "Fr", 1.0));
        currencyList.add(new Currency("CNY", "¥", 7.0));
        currencyList.add(new Currency("HKD", "$", 7.8));
        currencyList.add(new Currency("NZD", "$", 1.5));
        currencyList.add(new Currency("SEK", "kr", 9.0));
        currencyList.add(new Currency("SGD", "$", 1.4));
        currencyList.add(new Currency("KRW", "₩", 1200.0));
        currencyList.add(new Currency("MXN", "$", 20.0));
        currencyList.add(new Currency("NOK", "kr", 9.0));
        currencyList.add(new Currency("RUB", "₽", 70.0));
        currencyList.add(new Currency("INR", "₹", 70.0));
        currencyList.add(new Currency("ZAR", "R", 14.0));
        currencyList.add(new Currency("TRY", "₺", 6.0));
        currencyList.add(new Currency("BRL", "R$", 4.0));
        currencyList.add(new Currency("TWD", "NT$", 30.0));
        currencyList.add(new Currency("MYR", "RM", 4.0));
        currencyList.add(new Currency("PHP", "₱", 50.0));
        currencyList.add(new Currency("IDR", "Rp", 14000.0));
        currencyList.add(new Currency("THB", "฿", 30.0));
        currencyList.add(new Currency("VND", "₫", 23000.0));
        currencyList.add(new Currency("CZK", "Kč", 23.0));
        currencyList.add(new Currency("DKK", "kr", 6.5));
        currencyList.add(new Currency("HUF", "Ft", 300.0));
        currencyList.add(new Currency("PLN", "zł", 3.8));
        currencyList.add(new Currency("ILS", "₪", 3.5));
        return currencyList;
    }

    public void saveCurrencyList(ArrayList<Currency> currencyList) {
        // TODO @davidchd
    }

}
