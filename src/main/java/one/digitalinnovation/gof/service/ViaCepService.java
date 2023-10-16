package one.digitalinnovation.gof.service;

import one.digitalinnovation.gof.model.EnderecoModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws/")
public interface ViaCepService {
  @GetMapping (value = "/{cep}/json/")
  EnderecoModel consultarCep(@PathVariable String cep);
}
