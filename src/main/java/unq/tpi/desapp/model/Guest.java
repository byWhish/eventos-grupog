package unq.tpi.desapp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Guest")
public class Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn( name = "event_id")
    @JsonBackReference
    Event event;

    Boolean confirmedAssistance;

    @ManyToMany
    @JoinTable(
            name = "GuestProduct",
            joinColumns = @JoinColumn(name = "guest_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    List<Product> products;

    Boolean isOwner;

    public Guest(Event event, User user) {
        this.event = event;
        this.user = user;
        this.confirmedAssistance = Boolean.FALSE;
        this.products = new ArrayList<>();
    }

    public Guest(){}

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
