package one.digitalinnovation.gof.repository;

import one.digitalinnovation.gof.model.EnderecoModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends CrudRepository<EnderecoModel, String> {
}
