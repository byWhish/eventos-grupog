package unq.tpi.desapp.builders;

import unq.tpi.desapp.model.*;

import java.util.Date;
import java.util.List;

public class CommonAccountEventBuilder {

    private CommonAccountEvent event;

    public CommonAccountEventBuilder(){
        this.event = new CommonAccountEvent();
    }

    public static CommonAccountEventBuilder anCommonAccountEventBuilder() { return new CommonAccountEventBuilder(); }

    public CommonAccountEventBuilder withAccount(Account anAccount){
        this.event.setAccount(anAccount);
        return this;
    }

    public CommonAccountEventBuilder withOwner(User owner){
        this.event.setOwner(owner);
        return this;
    }

    public CommonAccountEventBuilder withDeadLine(Date deadLine){
        this.event.setDeadline(deadLine);
        return this;
    }

    public CommonAccountEventBuilder withName(String name){
        this.event.setName(name);
        return this;
    }

    public CommonAccountEventBuilder withGuests(List<Guest> guests) {
        this.event.setGuests(guests);
        return this;
    }

    public CommonAccountEventBuilder withProducts(List<Product> products) {
        this.event.setProducts(products);

        return this;
    }

    public CommonAccountEvent build(){
        return this.event;
    }

}
