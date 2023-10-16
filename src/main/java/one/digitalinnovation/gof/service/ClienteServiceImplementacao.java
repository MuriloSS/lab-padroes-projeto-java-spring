package one.digitalinnovation.gof.service;

import one.digitalinnovation.gof.model.ClienteModel;
import one.digitalinnovation.gof.model.EnderecoModel;
import one.digitalinnovation.gof.repository.ClienteRepository;
import one.digitalinnovation.gof.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImplementacao implements ClienteService{
  @Autowired
  private ClienteRepository clienteRepository;

  @Autowired
  EnderecoRepository enderecoRepository;

  @Autowired
  ViaCepService viaCepService;

  @Override
  public List<ClienteModel> buscarTodos() {
       return (List<ClienteModel>) clienteRepository.findAll();
  }

  @Override
  public Optional<ClienteModel> buscarPorId(Long id) {
    Optional<ClienteModel> clienteDb = clienteRepository.findById(id);
    if (clienteDb.isPresent()){
      return clienteDb;
    }
    return Optional.empty();
  }

  @Override
  public void inserir(ClienteModel cliente) {
    String cep = cliente.getEndereco().getCep();

    EnderecoModel endereco = enderecoRepository.findById(cep).orElseGet(() -> {
        EnderecoModel novoEndereco = viaCepService.consultarCep(cep);
        enderecoRepository.save(novoEndereco);
      return novoEndereco;
      }
    );

    cliente.setEndereco(endereco);
  }

  @Override
  public void atualizar(Long id, ClienteModel cliente) {
    Optional<ClienteModel> clienteBd = clienteRepository.findById(cliente.getId());
    if(clienteBd.isPresent()){
      inserir(cliente);
    }
  }

  @Override
  public void deletar(Long id) {
    clienteRepository.deleteById(id);

  }
}
