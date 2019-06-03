package unq.tpi.desapp.builders;

import unq.tpi.desapp.model.Template;
import unq.tpi.desapp.model.Product;
import unq.tpi.desapp.model.User;

import java.util.ArrayList;
import java.util.List;

public final class EventTemplateBuilder {
    private Template template;

    public EventTemplateBuilder() {
        template = new Template("name", new ArrayList<>());
        withName("name");
        withProducts(new ArrayList<>());
        withUsers(new ArrayList<>());
    }

    public static EventTemplateBuilder anEventTemplate() {
        return new EventTemplateBuilder();
    }

    public EventTemplateBuilder withName(String name) {
        template.setName(name);
        template.getName();
        return this;
    }

    public EventTemplateBuilder withProducts(List<Product> products) {
        template.setProducts(products);
        template.getProducts();
        return this;
    }

    public EventTemplateBuilder withUsers(List<User> users) {
        template.setUsers(users);
        template.getUsers();
        return this;
    }

    public Template build() {
        return template;
    }
}
