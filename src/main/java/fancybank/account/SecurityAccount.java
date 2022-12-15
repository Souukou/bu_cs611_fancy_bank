/*
 * Security Account is for stock trading
 */
package fancybank.account;

import java.util.ArrayList;

import fancybank.stock.Stock;
import fancybank.stock.StockHolding;
import fancybank.stock.StockMarket;

public class SecurityAccount extends Account implements Transferable, Tradable, CashOperable {
    private StockHoldingList stockHoldingList = new StockHoldingList();

    public SecurityAccount() {
        super(0, "security", 0, "USD");
    }

    public SecurityAccount(int accountNumber) {
        super(accountNumber, "security", 0, "USD");
    }

    // we only allow USD for stock account
    public SecurityAccount(int accountNumber, double balance) {
        super(accountNumber, "security", balance, "USD");
    }

    public StockHoldingList getStockHoldingList() {
        return stockHoldingList;
    }

    public void setStockHoldingList(StockHoldingList stockHoldingList) {
        this.stockHoldingList = stockHoldingList;
    }

    @Override
    public void transferTo(Account target, double amount) {
        if (amount < 0) {
            return;
        }
        if (!getBalance().isSufficient(amount)) {
            return;
        }
        getBalance().subtract(amount);
        target.getBalance().add(amount);
    }

    @Override
    public boolean buyStock(Stock stock, int quantity) {
        // query the latest market information
        stock = StockMarket.getInstance().getStock(stock.getSymbol());
        System.out.println("here");
        if (stock == null) {
            return false;
        }
        if (quantity <= 0) {
            return false;
        }
        System.out.println("here");
        double totalCost = stock.getPrice() * quantity;
        if (!getBalance().isSufficient(totalCost)) {
            return false;
        }
        System.out.println("here");

        getBalance().subtract(totalCost);
        System.out.println("here");

        StockHolding stockHolding = new StockHolding(stock, quantity);
        stockHoldingList.add(stockHolding);
        return true;
    }

    @Override
    public boolean buyStock(String symbol, int quantity) {
        Stock stock = StockMarket.getInstance().getStock(symbol);
        return buyStock(stock, quantity);
    }

    @Override
    public boolean sellStock(Stock stock, int quantity) {
        if (stock == null) {
            return false;
        }
        if (quantity <= 0) {
            return false;
        }
        ArrayList<StockHolding> stockHoldingList = this.stockHoldingList.getStockHoldingList(stock);
        if (stockHoldingList.size() == 0) {
            return false;
        }
        int totalQuantity = 0;
        for (StockHolding stockHolding : stockHoldingList) {
            totalQuantity += stockHolding.getQuantity();
        }
        if (totalQuantity < quantity) {
            return false;
        }
        double totalValue = stock.getPrice() * quantity;
        getBalance().add(totalValue);
        int remainingQuantity = quantity;
        for (StockHolding stockHolding : stockHoldingList) {
            if (stockHolding.getQuantity() <= remainingQuantity) {
                this.stockHoldingList.remove(stockHolding);
                remainingQuantity -= stockHolding.getQuantity();
            } else {
                stockHolding.setQuantity(stockHolding.getQuantity() - remainingQuantity);
                remainingQuantity = 0;
            }
            if (remainingQuantity == 0) {
                break;
            }
        }
        return true;
    }

    @Override
    public boolean sellStock(String symbol, int quantity) {
        Stock stock = StockMarket.getInstance().getStock(symbol);
        return sellStock(stock, quantity);
    }

	@Override
	public void deposit(double amount) {
		// TODO Auto-generated method stub
		getBalance().add(amount);
	}

	@Override
	public void withdraw(double amount) {
		// TODO Auto-generated method stub
		getBalance().subtract(amount);
	}
}
