package unq.tpi.desapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unq.tpi.desapp.model.User;
import unq.tpi.desapp.request.UserRequest;

@Service
public class AccountsService {

    @Autowired
    UserService userService;

    public void createUser(UserRequest userRequest) {
        User user = new User(
                userRequest.getName(),
                userRequest.getSurname(),
                userRequest.getEmail(),
                userRequest.getBirthDate()
        );
        userService.saveUser(user);
    };
}
