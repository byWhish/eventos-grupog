package unq.tpi.desapp.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import unq.tpi.desapp.model.Product;
import unq.tpi.desapp.model.Template;
import unq.tpi.desapp.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductWebService {

    @Autowired
    ProductService productService;

    @GetMapping("/all")
    public List<Product> getAllUsers() {
        return productService.findAllProducts();
    }

    @GetMapping("/templates")
    public List<Template> getAllTemplates() {
        return productService.findAllTemplates();
    }
}
