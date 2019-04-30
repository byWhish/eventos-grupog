package unq.tpi.desapp.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommonAccountEvent extends MoneyCollectionEvent {

    public List<Expense> expenses = new ArrayList<>();

    public CommonAccountEvent(){}

    public CommonAccountEvent(User owner, String name, Date deadLine, Account account) {
        super(owner, name, deadLine, account);
    }

    @Override
    public Double totalAmount() {
        return this.expenses.stream().mapToDouble(Expense::getAmount).sum();
    }

    public void informExpenses(Expense expense) {
        this.expenses.add(expense);
    }

    public Double getExpenses() {
        return expenses.stream().mapToDouble(expense -> expense.getAmount()).sum();
    }

    public void setExpenses(List<Expense> expenses) {
        this.expenses = expenses;
    }

    public Double getGuestExpeses(Guest guest) {
        return this.expenses.stream().filter(expense -> expense.getGuest() == guest).mapToDouble(expense -> expense.getAmount()).sum();
    }

    public Double refundExpenses(Guest guest) {
        return this.getGuestExpeses(guest) - this.amountToPay(guest);
    }
}
