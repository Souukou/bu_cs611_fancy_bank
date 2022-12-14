package fancybank.account;

public interface Exchangeable {
    public boolean exchangeTo(Account accouunt, Balance exBalance);
}