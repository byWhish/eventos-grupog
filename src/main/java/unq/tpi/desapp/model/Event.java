package unq.tpi.desapp.model;

import java.util.List;
import java.util.stream.Collectors;

public abstract class Event {

    Integer id;
    String name;
    String description;
    List<Product> products;
    List<Guest> guests;

    public Double totalAmount() {
        return products.stream()
                .mapToDouble(product -> priceFor(product))
                .sum();
    }

    public abstract Double amountToPay(Guest guest);

    private Double priceFor(Product product) {
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
                .filter(guest -> guest.assists())
                .collect(Collectors.toList());
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
