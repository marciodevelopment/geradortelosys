


        			            			            			
package br.org.curitiba.ici.saude.person.rest.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.org.curitiba.ici.saude.person.rest.mapper.PessoaMapper;
import br.org.curitiba.ici.saude.person.rest.web.response.PessoaResponse;
import br.org.curitiba.ici.saude.person.services.PessoaService;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("pessoas")
public class PessoaController {
  private final PessoaService pessoaService;
  private final PessoaMapper pessoaMapper;
  @GetMapping(path = "/{id}")
  public PessoaResponse buscarPorId(@NotNull @PathVariable("id") Integer id) {
    return pessoaMapper.toResponse(pessoaService.buscarPorIdOuThrow(id));
  }

}

