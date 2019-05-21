package unq.tpi.desapp.builders;

import unq.tpi.desapp.model.*;
import unq.tpi.desapp.model.event.BasketEvent;
import unq.tpi.desapp.model.event.CommonAccountEvent;
import unq.tpi.desapp.model.event.Event;
import unq.tpi.desapp.model.event.PartyEvent;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class EventBuilder {

    Event event;

    public EventBuilder(String type) {
        this.event = createEventFromType(type);
        Guest guest = new GuestBuilder(event).getGuest();

        withName("Un nombre");
        withDescription("Una descripcion");
        withGuests(Arrays.asList(guest));
        withProducts(Arrays.asList(new ProductBuilder().getProduct()));
    }

    private Event createEventFromType(String type) {
        HashMap eventMap = new HashMap() {{
            put("party", new PartyEvent());
            put("commonAccount", new CommonAccountEvent());
            put("basket", new BasketEvent());
        }};

        return (Event) eventMap.get(type);
    }

    public Event getEvent() {
        return this.event;
    }

    public EventBuilder withName(String name) {
        this.event.setName(name);
        event.getName();

        return this;
    }

    public EventBuilder withDescription(String description) {
        this.event.setDescription(description);
        event.getDescription();
        return this;
    }

    public EventBuilder withGuests(List<Guest> guests) {
        this.event.setGuests(guests);
        event.getGuests();

        return this;
    }

    public EventBuilder withProducts(List<Product> products) {
        this.event.setProducts(products);
        event.getProducts();

        return this;
    }

}
