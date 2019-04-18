package unq.tpi.desapp.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommonAccount extends MoneyCollectionEvent {

    public List<Expense> expenses;

    public CommonAccount(){}

    public CommonAccount(User owner, String name, Date deadLine, Account account) {
        super(owner, name, deadLine, account);
        this.expenses = new ArrayList<>();
    }

    @Override
    public Double totalAmount() {
        return this.expenses.stream().mapToDouble(Expense::getAmount).sum();
    }

    public void informExpenses(Expense expense) {
        this.expenses.add(expense);
    }


}
