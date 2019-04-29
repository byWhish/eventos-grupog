package unq.tpi.desapp.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import unq.tpi.desapp.model.User;

import java.util.Optional;

@Repository(value="userRepository")
public interface UserRepository extends CrudRepository<User, Long> {

    @Query("SELECT u FROM User u where u.email = :email")
    Optional<User> findUserByEmail(@Param("email") String email);
}