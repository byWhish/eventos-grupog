package unq.tpi.desapp.model;

import java.util.List;

public class Guest {

    Integer id;
    User user;
    Event event;
    Boolean confirmedAssistance;
    List<Product> products;
    Boolean isOwner;

    public Boolean assists() {
        return this.getConfirmedAssistance();
    }

    public Boolean collaboratesIn(Product product) {
        return products.stream()
                .anyMatch(guestProduct ->
                        guestProduct.getName().equals(product.getName())
                );
    }

    public Boolean getConfirmedAssistance() {
        return confirmedAssistance;
    }

    public void setConfirmedAssistance(Boolean confirmedAssistance) {
        this.confirmedAssistance = confirmedAssistance;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Boolean isOwner() {
        return isOwner;
    }

    public void setOwner(Boolean owner) {
        this.isOwner = owner;
    }
}
