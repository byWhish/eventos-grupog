package unq.tpi.desapp.builders;

import unq.tpi.desapp.model.Expense;
import unq.tpi.desapp.model.Guest;

public final class ExpenseBuilder {
    private Guest guest;
    private Double amount;

    public ExpenseBuilder() {
        withGuest(new GuestBuilder().getGuest());
        withAmount(0.0);
    }

    public ExpenseBuilder withGuest(Guest guest) {
        this.guest = guest;
        return this;
    }

    public ExpenseBuilder withAmount(Double amount) {
        this.amount = amount;
        return this;
    }

    public Expense build() {
        Expense expense = new Expense(guest, amount);
        expense.getAmount();
        expense.getGuest();
        expense.setAmount(amount);
        expense.setGuest(guest);
        return expense;
    }
}
