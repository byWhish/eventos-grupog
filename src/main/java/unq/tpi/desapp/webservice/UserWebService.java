package unq.tpi.desapp.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import unq.tpi.desapp.model.User;
import unq.tpi.desapp.request.UserRequest;
import unq.tpi.desapp.service.AccountsService;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "https://eventos-grupog.herokuapp.com/"})
@RequestMapping("/user")
public class UserWebService {

    @Autowired
    AccountsService accountsService;

    @PostMapping
    public void postUser(@RequestBody UserRequest userRequest) {
        accountsService.createUser(userRequest);
    }

    @GetMapping("/all")
    public List<User> getAllUsers() { return accountsService.findAllUsers(); }
}
