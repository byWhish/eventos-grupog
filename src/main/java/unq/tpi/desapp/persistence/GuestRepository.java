package unq.tpi.desapp.persistence;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import unq.tpi.desapp.model.Guest;

import java.util.Optional;

@Repository
public interface GuestRepository extends CrudRepository<Guest, Long> {

    @Query("SELECT g FROM Guest g where g.hash in :hash")
    Optional<Guest> findByHash(@Param("hash") String hash);
}