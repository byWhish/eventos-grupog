package unq.tpi.desapp.model;

public class Loan {

    public Double amount;
    public Integer fees;
    public Integer pendingFees;

    public Loan() {}

    public Loan(Double amount, Integer fees) {
        this.amount = amount;
        this.fees = fees;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getFees() {
        return fees;
    }

    public void setFees(Integer fees) {
        this.fees = fees;
    }

    public Integer getPendingFees() {
        return pendingFees;
    }

    public void setPendingFees(Integer pendingFees) {
        this.pendingFees = pendingFees;
    }

    public Integer getPaidFees() {
        return this.fees - this.pendingFees;
    }
}
