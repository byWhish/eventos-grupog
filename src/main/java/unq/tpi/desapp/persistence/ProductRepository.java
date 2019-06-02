package unq.tpi.desapp.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import unq.tpi.desapp.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {}
