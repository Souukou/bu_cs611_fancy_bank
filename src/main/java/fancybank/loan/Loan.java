package fancybank.loan;

import fancybank.user.UID;

public class Loan {
    private UID uid;
    private double amount;
    private double interestRate;
    private Collateral collateral;
    private double unpaidAmount;
    private boolean isApproved;

    public Loan(UID uid, double amount, double interestRate, Collateral collateral) {
        this.uid = uid;
        this.amount = amount;
        this.interestRate = interestRate;
        this.collateral = collateral;
        this.unpaidAmount = amount;
        this.isApproved = false;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void approve() {
        this.isApproved = true;
    }

    public double getUnpaidAmount() {
        return unpaidAmount;
    }

    public void setUnpaidAmount(double unpaidAmount) {
        this.unpaidAmount = unpaidAmount;
    }

    public boolean isPaidFully() {
        return unpaidAmount == 0;
    }

    public void pay(double amount) {
        if (amount > unpaidAmount) {
            unpaidAmount = 0;
        } else {
            unpaidAmount -= amount;
        }
    }

    public UID getUid() {
        return uid;
    }

    public void setUid(UID uid) {
        this.uid = uid;
    }

    public double getAmount() {
        return amount;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public Collateral getCollateral() {
        return collateral;
    }

    public void setCollateral(Collateral collateral) {
        this.collateral = collateral;
    }

}
