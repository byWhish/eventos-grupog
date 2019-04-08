package unq.tpi.desapp.model;

import java.util.List;

public abstract class Event {

    String name;
    String description;
    List<Product> products;
    List<User> collaborators;
    User owner;

    public Double totalAmount() {
        return products.stream().mapToDouble
                (product -> priceFor(product)).sum();
    }

    private Double priceFor(Product product) {
        Double amountToBuy = Math.ceil(amountOfCollaborators() / (double) product.amountLimit);
        return product.price * amountToBuy;
    }

    private Integer amountOfCollaborators() {
        Integer collaboratorAmount = collaborators.size();
        return collaboratorAmount == 0 ? 1 : collaboratorAmount;
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

    public List<User> getCollaborators() {
        return collaborators;
    }

    public void setCollaborators(List<User> collaborators) {
        this.collaborators = collaborators;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

}
