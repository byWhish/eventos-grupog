package unq.tpi.desapp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.apache.commons.codec.digest.DigestUtils;
import unq.tpi.desapp.model.event.Event;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Entity
@Table(name="Guest")
public class Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn( name = "event_id")
    @JsonBackReference
    Event event;

    Boolean confirmedAssistance;

    Boolean payed;

    @ManyToMany
    @JoinTable(
            name = "GuestProduct",
            joinColumns = @JoinColumn(name = "guest_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    List<Product> products;

    private String hash;

    public Guest() {}

    public Guest(Event event, User user) {
        this.event = event;
        this.user = user;
        this.confirmedAssistance = Boolean.FALSE;
        this.payed = Boolean.FALSE;
        this.products = new ArrayList<>();
        generateHash();
    }

    public void generateHash() {
        if (this.hash != null) return;
        String originalString = new Date().toString() + user.getName() + event.getName() + new Random().nextInt(Integer.MAX_VALUE);
        this.hash = DigestUtils.sha256Hex(originalString);
    }

    public Boolean assists() {
        return this.getConfirmedAssistance();
    }

    public Boolean getPayed() {
        return payed;
    }

    public void setPayed(Boolean payed) {
        this.payed = payed;
    }

    public Boolean collaboratesIn(Product product) {
        return products.stream()
                .anyMatch(guestProduct ->
                        guestProduct.getName().equals(product.getName())
                );
    }

    public Double amountToPay() {
        return this.event.amountToPay(this);
    }

    public void confirmAssistance() {
        event.confirmAssistanceFor(this);
    }

    public void secureConfirmAssistance() {
        this.setConfirmedAssistance(Boolean.TRUE);
    }

    public Boolean getConfirmedAssistance() {
        return confirmedAssistance;
    }

    public void setConfirmedAssistance(Boolean confirmedAssistance) {
        this.confirmedAssistance = confirmedAssistance;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
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

    public Long getId() { return id; }

    public User getUser() {
        return this.user;
    }

    public Event getEvent() {
        return this.event;
    }

    public String getHash() {
        return this.hash;
    }
}
