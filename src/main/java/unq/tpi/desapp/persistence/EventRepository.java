package unq.tpi.desapp.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import unq.tpi.desapp.model.event.Event;

@Repository
public interface EventRepository extends CrudRepository<Event, Long> {
}