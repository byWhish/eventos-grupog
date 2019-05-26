package unq.tpi.desapp.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import unq.tpi.desapp.model.Account;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {}
