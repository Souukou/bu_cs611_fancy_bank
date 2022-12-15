package fancybank.loan;

public class Collateral {
    private String itemName;
    private double value;
    private String proof;

    public Collateral(String itemName, double value, String proof) {
        this.itemName = itemName;
        this.value = value;
        this.proof = proof;
    }

    public String getItemName() {
        return itemName;
    }

    public double getValue() {
        return value;
    }

    public String getProof() {
        return proof;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void setProof(String proof) {
        this.proof = proof;
    }

}
