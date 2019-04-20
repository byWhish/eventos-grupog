package unq.tpi.desapp.persistence;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import unq.tpi.desapp.model.User;

import java.util.Optional;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {

    @Query("SELECT u.title FROM User u where u.email = :email")
    Optional<User> findUserByEmail(@Param("email") Long email);
}