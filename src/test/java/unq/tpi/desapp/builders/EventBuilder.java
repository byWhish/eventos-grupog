package unq.tpi.desapp.builders;

import unq.tpi.desapp.model.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventBuilder {

    Event event;

    public EventBuilder(String type) {
        this.event = createEventFromType(type);
        Guest guest = new GuestBuilder(event).getGuest();

        this.event.setName("Un nombre");
        this.event.setDescription("Una descripcion");
        this.event.setGuests(Arrays.asList(guest));
        this.event.setProducts(Arrays.asList(new ProductBuilder().getProduct()));
    }

    private Event createEventFromType(String type) {
        HashMap eventMap = new HashMap() {{
            put("party", new PartyEvent());
            put("commonAccount", new CommonAccountEvent());
            put("selfProduct", new SelfProductEvent());
            put("basket", new BasketEvent());
        }};

        return (Event) eventMap.get(type);
    }

    public Event getEvent() {
        return this.event;
    }

    public EventBuilder withName(String name) {
        this.event.setName(name);

        return this;
    }

    public EventBuilder withDescription(String description) {
        this.event.setDescription(description);

        return this;
    }

    public EventBuilder withGuests(List<Guest> guests) {
        this.event.setGuests(guests);

        return this;
    }

    public EventBuilder withProducts(List<Product> products) {
        this.event.setProducts(products);

        return this;
    }

}
