package unq.tpi.desapp.builders;

import unq.tpi.desapp.model.Product;

public class ProductBuilder {

    Product product;

    public ProductBuilder() {
        this.product = new Product();
        withPrice(10.60);
        withAmountLimit(3);
        withName("Ketchup");
    }

    private ProductBuilder withName(String name) {
        this.product.setName(name);
        product.getName();
        return this;
    }

    public ProductBuilder withPrice(Double price) {
        this.product.setPrice(price);
        product.getPrice();
        return this;
    }

    public ProductBuilder withAmountLimit(Integer amountLimit) {
        this.product.setAmountLimit(amountLimit);
        product.getAmountLimit();
        return this;
    }

    public Product getProduct() {
        return product;
    }

}
