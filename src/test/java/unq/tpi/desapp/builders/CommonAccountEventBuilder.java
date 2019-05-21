package unq.tpi.desapp.builders;

import unq.tpi.desapp.model.*;
import unq.tpi.desapp.model.event.CommonAccountEvent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class CommonAccountEventBuilder {

    private CommonAccountEvent event;

    public CommonAccountEventBuilder(){
        this.event = new CommonAccountEvent();
        withGuests(new ArrayList<>());
        withAccount(AccountBuilder.anAccount().build());
        withProducts(new ArrayList<>());
        Date tomorrow = new Date(new Date().getTime() + (1000 * 60 * 60 * 24));
        withDeadLine(tomorrow);
        withName("name");
        withOwner(new UserBuilder().getUser());
        withExpenses(new ArrayList<Expense>(Arrays.asList(new Expense(null, 1.0))));
    }

    public static CommonAccountEventBuilder anCommonAccountEventBuilder() { return new CommonAccountEventBuilder(); }

    public CommonAccountEventBuilder withAccount(Account anAccount){
        this.event.setAccount(anAccount);
        this.event.getExpenses();
        return this;
    }

    public CommonAccountEventBuilder withOwner(User owner){
        this.event.setOwner(owner);
        event.getOwner();
        return this;
    }

    public CommonAccountEventBuilder withDeadLine(Date deadLine){
        this.event.setDeadline(deadLine);
        event.getDeadline();
        return this;
    }

    public CommonAccountEventBuilder withName(String name){
        this.event.setName(name);
        event.getName();
        return this;
    }

    public CommonAccountEventBuilder withGuests(List<Guest> guests) {
        this.event.setGuests(guests);
        event.getGuests();
        return this;
    }

    public CommonAccountEventBuilder withProducts(List<Product> products) {
        this.event.setProducts(products);
        event.getProducts();
        return this;
    }

    public CommonAccountEventBuilder withExpenses(List<Expense> expenses) {
        this.event.setExpenses(expenses);
        event.getExpenses();
        return this;
    }

    public CommonAccountEvent build(){
        return this.event;
    }

}
