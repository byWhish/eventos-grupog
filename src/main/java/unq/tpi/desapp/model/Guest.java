package unq.tpi.desapp.model;

import java.util.List;

public class Guest {

    Integer id;
    User user;
    Event event;
    Boolean confirmedAssistance;
    List<Product> products;

    public Boolean assists() {
        return this.getConfirmedAssistance();
    }

    public Boolean collaboratesIn(Product product) {
        return products.stream()
                .filter(guestProduct ->
                        guestProduct.getId().equals(product.getId())
                )
                .findFirst().isPresent();
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
}
