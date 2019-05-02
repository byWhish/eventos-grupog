package unq.tpi.desapp.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Inheritance
@DiscriminatorColumn(name="type")
@Table(name="Event")
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
public abstract class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    String name;
    String description;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "event_id")
    List<Product> products;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Guest> guests;

    @OneToOne
    @JoinColumn(name = "user_id")
    User owner;

    Date deadline;

    public Event(){}

    public Event(User owner, String name, Date deadline) {
        this.owner = owner;
        this.name = name;
        this.deadline = deadline;
        this.products = new ArrayList<>();
        this.guests = new ArrayList<>();
    }

    public Double totalAmount() {
        return priceForProducts(this.products);
    }

    public abstract Double amountToPay(Guest guest);

    protected Double priceFor(Product product) {
        Double amountToBuy = Math.ceil(amountOfCollaboratorsFor(product) / (double) product.amountLimit);
        return product.price * amountToBuy;
    }

    private Integer amountOfCollaboratorsFor(Product product) {
        Integer collaboratorAmount = collaboratorsFor(product).size();
        return collaboratorAmount == 0 ? 1 : collaboratorAmount;
    }

    protected List<Guest> collaboratorsFor(Product product) {
        return collaborators();
    }

    protected List<Guest> collaborators() {
        return guests.stream()
                .filter(Guest::assists)
                .collect(Collectors.toList());
    }

    protected Double priceForProducts(List<Product> productList) {
        return productList.stream()
                .mapToDouble(this::priceFor)
                .sum();
    }

    protected void confirmAssistance(Guest guest) throws Exception {
        if (this.deadline.before(new Date())) {
            guest.setConfirmedAssistance(true);
        } else {
            throw new Exception("No es posible realizar la operacion");
        }
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Guest> getGuests() {
        return guests;
    }

    public void setGuests(List<Guest> guests) {
        this.guests = guests;
    }

}
