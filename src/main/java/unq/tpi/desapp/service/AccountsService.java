package unq.tpi.desapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unq.tpi.desapp.model.User;

@Service
public class AccountsService {

    @Autowired
    UserService userService;

    public void createUser(User user) {
        userService.saveUser(user);
    };
}
