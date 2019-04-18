package unq.tpi.desapp.model;

public class Expense {

    private Guest guest;
    private Double amount;

    public Expense(Guest guest, Double amount) {
        this.guest = guest;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
