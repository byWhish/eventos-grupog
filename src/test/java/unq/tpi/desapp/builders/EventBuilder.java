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
        User user = new UserBuilder().getUser();

        this.event.setName("Un nombre");
        this.event.setDescription("Una descripcion");
        this.event.setOwner(user);
        this.event.setCollaborators(Arrays.asList(user));
        this.event.setProducts(Arrays.asList(new ProductBuilder().getProduct()));
    }

    private Event createEventFromType(String type) {
        Map<String, Event> eventMap = new HashMap() {{
            put("party", new PartyEvent());
            put("moneyCollection", new MoneyCollectionEvent());
            put("basket", new BasketEvent());
        }};

        return eventMap.get(type);
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

    public EventBuilder withOwner(User owner) {
        this.event.setOwner(owner);

        return this;
    }

    public EventBuilder withCollaborators(List<User> collaborators) {
        this.event.setCollaborators(collaborators);

        return this;
    }

    public EventBuilder withProducts(List<Product> products) {
        this.event.setProducts(products);

        return this;
    }

}
