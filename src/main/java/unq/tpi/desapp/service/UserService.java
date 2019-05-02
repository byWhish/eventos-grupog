package unq.tpi.desapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unq.tpi.desapp.model.User;
import unq.tpi.desapp.persistence.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void saveUser(User user) {
        this.userRepository.save(user);
    }

    public Optional<User> findUserById(long id) {
        return userRepository.findById(id);
    }

    public List<User> findUsersByIds(List<Long> ids) {
        return userRepository.findByMultipleIds(ids);
    }

    public List<User> findAllUsers() {
        return (List<User>) this.userRepository.findAll();
    }
}
