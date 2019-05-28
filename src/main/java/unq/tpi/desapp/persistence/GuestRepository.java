package unq.tpi.desapp.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import unq.tpi.desapp.model.Guest;

@Repository
public interface GuestRepository extends CrudRepository<Guest, Long> {
}