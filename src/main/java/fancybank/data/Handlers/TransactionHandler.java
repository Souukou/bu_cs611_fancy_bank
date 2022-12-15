package fancybank.data.Handlers;

import fancybank.transaction.Transaction;

/**
 * @author Haodong Chen hjc5283@bu.edu
 * Class for maintaining customers' transactions. 
 */
public class TransactionHandler implements ArrayAppend<Transaction> {

    private Transaction[] transactions;

    public TransactionHandler() {
        transactions = new Transaction[0];
    }

    public Transaction[] getTransactions() {
        return transactions;
    }

    public void setTransactions(Transaction[] transactions) {
        this.transactions = transactions;
    }

    public void addTransaction(Transaction e) {
        transactions = addElement(transactions, e);
    }
    
}
