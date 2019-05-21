package unq.tpi.desapp.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import unq.tpi.desapp.model.User;
import unq.tpi.desapp.service.AccountsService;

@RestController
public class UserWebService {

    @Autowired
    AccountsService accountsService;

    @PostMapping(value="/user/add")
    public User postUser(@RequestBody User user) {
        return accountsService.createUser(user);
    }
}
