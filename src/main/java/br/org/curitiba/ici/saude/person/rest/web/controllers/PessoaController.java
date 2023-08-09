


        			            			            			
package br.org.curitiba.ici.saude.person.rest.web.controllers;

import br.org.curitiba.ici.saude.entities.Pessoa;
import br.org.curitiba.ici.saude.service.PessoaService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import lombok.*;
import jakarta.persistence.*;
import jakarta.validation.*;
import br.org.curitiba.ici.saude.common.*;
import br.org.curitiba.ici.saude.*;

/*
import br.org.curitiba.ici.saude.common.PageResponse;
import br.org.curitiba.ici.saude.common.PaginationRequest;

import br.org.curitiba.ici.saude.medicamento.rest.mapper.PessoaMapper;
import br.org.curitiba.ici.saude.medicamento.rest.web.request.PessoaAtualizacaoRequest;
import br.org.curitiba.ici.saude.medicamento.rest.web.request.PessoaNovoRequest;
import br.org.curitiba.ici.saude.medicamento.rest.web.request.PessoaPesquisaRequest;
import br.org.curitiba.ici.saude.medicamento.rest.web.response.PessoaPesquisaResponse;
import br.org.curitiba.ici.saude.medicamento.rest.web.response.PessoaResponse;
import br.org.curitiba.ici.saude.medicamento.service.PessoaService;
*/
import jakarta.validation.Valid;
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

