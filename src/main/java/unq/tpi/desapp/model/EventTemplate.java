package unq.tpi.desapp.model;

import java.util.ArrayList;
import java.util.List;

public class EventTemplate {

    private String name;
    private List<Product> products = new ArrayList<>();
    private List<User> users = new ArrayList<>();

    public EventTemplate(){}

    public EventTemplate(String name, List<Product> products){
        this.name = name;
        this.products = products;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

}
