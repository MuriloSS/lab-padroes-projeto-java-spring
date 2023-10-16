package one.digitalinnovation.gof.repository;

import one.digitalinnovation.gof.model.ClienteModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepository<ClienteModel, Long> {
}
