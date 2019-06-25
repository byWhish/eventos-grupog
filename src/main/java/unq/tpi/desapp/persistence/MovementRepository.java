package unq.tpi.desapp.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import unq.tpi.desapp.model.Movement;

@Repository
public interface MovementRepository extends CrudRepository<Movement, Long> {}
