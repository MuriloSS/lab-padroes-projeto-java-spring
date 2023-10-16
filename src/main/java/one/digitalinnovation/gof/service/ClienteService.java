package one.digitalinnovation.gof.service;

import one.digitalinnovation.gof.model.ClienteModel;

import java.util.List;
import java.util.Optional;

public interface ClienteService {
  List<ClienteModel> buscarTodos();

  Optional<ClienteModel> buscarPorId(Long id);

  void inserir(ClienteModel cliente);
  void atualizar(Long id, ClienteModel cliente);

  void deletar(Long id);

}
