package unq.tpi.desapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.domain.EntityScan;
//import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
//@EntityScan("unq.tpi.desapp")
//@EnableJpaRepositories(basePackages = {"unq.tpi.desapp.persistence", "unq.tpi.desapp.service"})
//@ComponentScan("unq.tpi.desapp")
public class App {
    public static void main( String[] args ) {
        SpringApplication.run(App.class, args);
    }
}
