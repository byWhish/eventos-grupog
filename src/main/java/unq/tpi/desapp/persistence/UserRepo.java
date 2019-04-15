package unq.tpi.desapp.persistence;

import org.springframework.data.repository.CrudRepository;
import unq.tpi.desapp.model.User;

public interface UserRepo extends CrudRepository<User, Long>{}

