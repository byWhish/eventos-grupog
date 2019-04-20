package unq.tpi.desapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import unq.tpi.desapp.model.User;
import unq.tpi.desapp.persistence.UserRepo;

import java.util.List;
import java.util.Optional;

public class UserService {

    @Autowired
    private UserRepo repo;

    public void saveUser(User user) {
        this.repo.save(user);
    }

    public Optional<User> findUserById(long id) {
        return repo.findById(id);
    }

    public List<User> findAllUsers() {
        return (List<User>) this.repo.findAll();
    }
}
