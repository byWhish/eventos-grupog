package unq.tpi.desapp.builders;

import unq.tpi.desapp.model.EventTemplate;
import unq.tpi.desapp.model.Product;
import unq.tpi.desapp.model.User;

import java.util.ArrayList;
import java.util.List;

public final class EventTemplateBuilder {
    private EventTemplate eventTemplate;

    public EventTemplateBuilder() {
        eventTemplate = new EventTemplate("name", new ArrayList<>());
        withName("name");
        withProducts(new ArrayList<>());
        withUsers(new ArrayList<>());
    }

    public static EventTemplateBuilder anEventTemplate() {
        return new EventTemplateBuilder();
    }

    public EventTemplateBuilder withName(String name) {
        eventTemplate.setName(name);
        eventTemplate.getName();
        return this;
    }

    public EventTemplateBuilder withProducts(List<Product> products) {
        eventTemplate.setProducts(products);
        eventTemplate.getProducts();
        return this;
    }

    public EventTemplateBuilder withUsers(List<User> users) {
        eventTemplate.setUsers(users);
        eventTemplate.getUsers();
        return this;
    }

    public EventTemplate build() {
        return eventTemplate;
    }
}
