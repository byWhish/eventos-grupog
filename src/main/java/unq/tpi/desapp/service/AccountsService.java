package unq.tpi.desapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unq.tpi.desapp.model.User;
import unq.tpi.desapp.persistence.UserRepository;
import unq.tpi.desapp.request.ProfileRequest;
import unq.tpi.desapp.request.UserRequest;

import java.util.List;

@Service
public class AccountsService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(UserRequest userRequest) {
        User user = new User(
                userRequest.getName(),
                userRequest.getSurname(),
                userRequest.getEmail()
        );

        return this.saveUser(user);
    };


    public void createUsers(List<UserRequest> users) {
        users.forEach( user -> this.createUser(user));
    }

    public User saveUser(User user) {
        return this.userRepository.save(user);
    }

    public void saveUsers(List<User> users) {
        users.forEach( user -> this.saveUser(user));
    }

    public User findUserById(long id) {
        return userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user id " + id));
    }

    public List<User> findUsersByIds(List<Long> ids) {
        return userRepository.findByMultipleIds(ids);
    }

    public List<User> findAllUsers() {
        return (List<User>) this.userRepository.findAll();
    }

    public User createUserFromProfile(ProfileRequest profile) {
        User user = new User(
                profile.getGiven_name(),
                profile.getFamily_name(),
                profile.getEmail()
        );
        return this.saveUser(user);
    }

    public User authProfile(ProfileRequest profile) {
        User user = this.userRepository.findByEmail(profile.getEmail());
        if (user == null){
            return this.createUserFromProfile(profile);
        }
        return user;
    }
}
