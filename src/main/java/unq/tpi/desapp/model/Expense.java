package unq.tpi.desapp.model;

public class Expense {

    private Guest guest;
    private Double amount;

    public Expense(Guest guest, Double amount) {
        this.guest = guest;
        this.amount = amount;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }
}
