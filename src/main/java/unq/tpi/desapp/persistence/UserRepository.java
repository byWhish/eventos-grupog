package unq.tpi.desapp.persistence;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import unq.tpi.desapp.model.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    // @Query("SELECT u FROM User u where u.email = :email")
    // Optional<User> findUserByEmail(@Param("email") String email);

    User findByEmail(String email);

    @Query("SELECT u FROM User u where u.id in :ids")
    List<User> findByMultipleIds(@Param("ids") List<Long> ids);
}