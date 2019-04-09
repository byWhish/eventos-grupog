package unq.tpi.desapp.builders;

import unq.tpi.desapp.model.Product;

public class ProductBuilder {

    Product product;

    public ProductBuilder() {
        this.product = new Product();
        product.setPrice(10.60);
        product.setAmountLimit(3);
    }

    public ProductBuilder withPrice(Double price) {
        this.product.setPrice(price);

        return this;
    }

    public ProductBuilder withAmountLimit(Integer amountLimit) {
        this.product.setAmountLimit(amountLimit);

        return this;
    }

    public Product getProduct() {
        return product;
    }

}
