package unq.tpi.desapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unq.tpi.desapp.model.Product;
import unq.tpi.desapp.model.Template;
import unq.tpi.desapp.persistence.ProductRepository;
import unq.tpi.desapp.persistence.TemplateRepository;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private TemplateRepository templateRepository;


    public void saveProduct(Product product) {
        this.productRepository.save(product);
    }

    public void createProducts(List<Product> products) {
        products.forEach( product -> this.saveProduct(product));
    }

    public List<Product> findAllProducts() {
        return (List<Product>) this.productRepository.findAll();
    }

    public void saveTemplate(Template template) {
        this.templateRepository.save(template);
    }

    public void createTemplates(List<Template> templates) {
        templates.forEach( template -> this.saveTemplate(template));
    }

    public List<Template> findAllTemplates() {
        return (List<Template>) this.templateRepository.findAll();
    }
}
