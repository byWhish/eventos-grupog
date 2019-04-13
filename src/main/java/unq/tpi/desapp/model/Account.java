package unq.tpi.desapp.model;

public class Account {

    private Double balance;
    private String id;
    private String alias;

    public void debit(Double amount) throws Exception {
        if ( amount > this.balance ) throw new Exception("Insuficient founds");
        this.balance = this.balance - amount;
    }

    public void credit(Double amount) {
        this.balance = this.balance + amount;
    }

    public Account() {}

    public Account( String id, String alias ){
        this.id = id;
        this.alias = alias;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

}
