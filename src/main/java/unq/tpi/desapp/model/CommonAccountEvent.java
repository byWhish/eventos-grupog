package unq.tpi.desapp.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@DiscriminatorValue(CommonAccountEvent.TYPE)
public class CommonAccountEvent extends MoneyCollectionEvent {

    public static final String TYPE = "commonAccount";

    @OneToMany
    @JoinColumn(name = "event_id")
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
