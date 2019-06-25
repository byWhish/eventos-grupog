package unq.tpi.desapp.runners;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import unq.tpi.desapp.model.Product;
import unq.tpi.desapp.service.ProductService;
import unq.tpi.desapp.webservice.GuestWebService;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Component
@Order(3)
public class ProductRunner implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductRunner.class);

    @Autowired
    ProductService productService;

    @Override
    public void run(String... args) throws Exception {
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<Product>> typeReference = new TypeReference<List<Product>>(){};
            InputStream inputStream = TypeReference.class.getResourceAsStream("/json/products.json");
            try {
                List<Product> products = mapper.readValue(inputStream,typeReference);
                productService.createProducts(products);
                LOGGER.info("Products Saved!");
            } catch (IOException e){
                LOGGER.error("Unable to save products: " + e.getMessage());
            }
    }
}
