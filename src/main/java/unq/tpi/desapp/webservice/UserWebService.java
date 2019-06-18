package unq.tpi.desapp.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import unq.tpi.desapp.model.User;
import unq.tpi.desapp.request.ProfileRequest;
import unq.tpi.desapp.request.UserRequest;
import unq.tpi.desapp.service.AccountsService;

import java.util.List;

@RestController
@RequestMapping("api/private/user")
public class UserWebService {

    @Autowired
    AccountsService accountsService;

    @PostMapping
    public User postUser(@RequestBody UserRequest userRequest) {
        return accountsService.createUser(userRequest);
    }


    @PostMapping("/auth")
    public User auth(@RequestBody ProfileRequest profileRequest) { return accountsService.authProfile(profileRequest);}

    @GetMapping("/all")
    public List<User> getAllUsers() { return accountsService.findAllUsers(); }
}
