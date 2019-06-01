package unq.tpi.desapp;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import unq.tpi.desapp.model.Product;
import unq.tpi.desapp.request.UserRequest;
import unq.tpi.desapp.service.AccountsService;
import unq.tpi.desapp.service.ProductService;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
@EnableAutoConfiguration
public class App {
    public static void main( String[] args ) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    CommandLineRunner userrunner(AccountsService accountsService) {
        return args -> {
            // read json and write to db
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<UserRequest>> typeReference = new TypeReference<List<UserRequest>>(){};
            InputStream inputStream = TypeReference.class.getResourceAsStream("/json/users.json");
            try {
                List<UserRequest> users = mapper.readValue(inputStream,typeReference);
                accountsService.createUsers(users);
                System.out.println("Users Saved!");
            } catch (IOException e){
                System.out.println("Unable to save users: " + e.getMessage());
            }
        };
    }

    @Bean
    CommandLineRunner productrunner(ProductService productService) {
        return args -> {
            // read json and write to db
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<Product>> typeReference = new TypeReference<List<Product>>(){};
            InputStream inputStream = TypeReference.class.getResourceAsStream("/json/products.json");
            try {
                List<Product> products = mapper.readValue(inputStream,typeReference);
                productService.createProducts(products);
                System.out.println("Products Saved!");
            } catch (IOException e){
                System.out.println("Unable to save products: " + e.getMessage());
            }
        };
    }
}
