package unq.tpi.desapp.model;

public class Transfer {

    public Account origin;
    public Account destination;
    public Double amount;

    public Transfer() { }

    public Transfer(Account origin, Account destination, Double amount) {
        this.origin = origin;
        this.destination = destination;
        this.amount = amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public void commit() throws Exception {
        this.origin.debit(this.amount);
        this.destination.credit(this.amount);
    }

    public Account getOrigin() {
        return origin;
    }

    public void setOrigin(Account origin) {
        this.origin = origin;
    }

    public Account getDestination() {
        return destination;
    }

    public void setDestination(Account destination) {
        this.destination = destination;
    }

    public Double getAmount() {
        return amount;
    }
}
