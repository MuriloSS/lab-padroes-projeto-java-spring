package one.digitalinnovation.gof.controller;

import one.digitalinnovation.gof.model.ClienteModel;
import one.digitalinnovation.gof.repository.ClienteRepository;
import one.digitalinnovation.gof.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("clientes")
@RestController
public class ClienteController {
  @Autowired
  private ClienteService clienteService;
  @GetMapping
  public ResponseEntity<List<ClienteModel>> buscarTodos(){
    return ResponseEntity.ok().body(clienteService.buscarTodos());
  }
  @GetMapping("/{id}")
  public ResponseEntity<ClienteModel> buscarPorId(Long id){
    return (ResponseEntity<ClienteModel>) ResponseEntity.ok();
  }

  @PostMapping
  public ResponseEntity<ClienteModel> inserir(@RequestBody ClienteModel cliente){
    clienteService.inserir(cliente);
    return ResponseEntity.ok(cliente);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<ClienteModel> deletar(@RequestBody Long id){
    clienteService.deletar(id);
    return ResponseEntity.ok().build();
  }
  @PutMapping("/{id}")
  public ResponseEntity<ClienteModel> alterar(@RequestBody Long id, ClienteModel cliente){
    clienteService.atualizar(id, cliente);
    return ResponseEntity.ok(cliente);
  }


}
