package unq.tpi.desapp.model;

import java.util.ArrayList;
import java.util.List;

public class MoneyCollectionEvent extends Event {

    public List<Expense> expenses;

    public MoneyCollectionEvent(){}

    public MoneyCollectionEvent(User owner, String name) {
        super(owner, name);
        this.expenses = new ArrayList<>();
    }

    public void informExpenses(Expense expense) {
        this.expenses.add(expense);
    }

    @Override
    public Double amountToPay(Guest guest) {
        return totalAmount() / collaborators().size();
    }

    @Override
    public Double totalAmount() {
        return this.expenses.stream().mapToDouble(Expense::getAmount).sum();
    }

}