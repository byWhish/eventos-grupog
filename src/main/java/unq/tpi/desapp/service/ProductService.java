package unq.tpi.desapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unq.tpi.desapp.model.Product;
import unq.tpi.desapp.persistence.ProductRepository;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public void saveProduct(Product product) {
        this.productRepository.save(product);
    }

    public void createProducts(List<Product> products) {
        products.forEach( product -> this.saveProduct(product));
    }

    public List<Product> findAllProducts() {
        return (List<Product>) this.productRepository.findAll();
    }
}
