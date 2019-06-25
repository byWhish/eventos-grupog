package unq.tpi.desapp.runners;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import unq.tpi.desapp.request.UserRequest;
import unq.tpi.desapp.service.AccountsService;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Component
@Order(2)
public class UserRunner implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserRunner.class);

    @Autowired
    AccountsService accountsService;

    @Override
    public void run(String... args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<UserRequest>> typeReference = new TypeReference<List<UserRequest>>(){};
            InputStream inputStream = TypeReference.class.getResourceAsStream("/json/users.json");
            try {
                List<UserRequest> users = mapper.readValue(inputStream,typeReference);
                accountsService.createUsers(users);
                LOGGER.info("Users Saved!");
            } catch (IOException e){
                LOGGER.error("Unable to save users: " + e.getMessage());
            }
    }
}
