package unq.tpi.desapp.builders;

import unq.tpi.desapp.model.EventTemplate;
import unq.tpi.desapp.model.Product;
import unq.tpi.desapp.model.User;

import java.util.List;

public final class EventTemplateBuilder {
    private EventTemplate eventTemplate;

    private EventTemplateBuilder() {
        eventTemplate = new EventTemplate();
    }

    public static EventTemplateBuilder anEventTemplate() {
        return new EventTemplateBuilder();
    }

    public EventTemplateBuilder withName(String name) {
        eventTemplate.setName(name);
        return this;
    }

    public EventTemplateBuilder withProducts(List<Product> products) {
        eventTemplate.setProducts(products);
        return this;
    }

    public EventTemplateBuilder withUsers(List<User> users) {
        eventTemplate.setUsers(users);
        return this;
    }

    public EventTemplate build() {
        return eventTemplate;
    }
}
