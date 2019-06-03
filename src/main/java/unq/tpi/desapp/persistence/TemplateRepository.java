package unq.tpi.desapp.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import unq.tpi.desapp.model.Template;

@Repository
public interface TemplateRepository extends CrudRepository<Template, Long> {}
