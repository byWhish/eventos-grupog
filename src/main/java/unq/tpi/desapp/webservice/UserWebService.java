package unq.tpi.desapp.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import unq.tpi.desapp.request.UserRequest;
import unq.tpi.desapp.service.AccountsService;

@RestController
@RequestMapping("/user")
public class UserWebService {

    @Autowired
    AccountsService accountsService;

    @PostMapping
    public void postUser(@RequestBody UserRequest userRequest) {
        accountsService.createUser(userRequest);
    }
}
