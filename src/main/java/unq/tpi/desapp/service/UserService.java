package unq.tpi.desapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unq.tpi.desapp.model.User;
import unq.tpi.desapp.persistence.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        return this.userRepository.save(user);
    }

    public User findUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user id " + id));
    }

    public List<User> findUsersByIds(List<Long> ids) {
        return userRepository.findByMultipleIds(ids);
    }

    public List<User> findAllUsers() {
        return (List<User>) this.userRepository.findAll();
    }
}
