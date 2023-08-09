


                	    	    	            		    	                	    	    	                    		    	                    		    	    
package br.org.curitiba.ici.saude.person.rest.web.controller;

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
import br.org.curitiba.ici.saude.common.PageResponse;
import br.org.curitiba.ici.saude.common.PaginationRequest;
import br.org.curitiba.ici.saude.person.rest.mapper.FabricanteMapper;
import br.org.curitiba.ici.saude.person.rest.web.request.FabricanteAtualizacaoRequest;
import br.org.curitiba.ici.saude.person.rest.web.request.FabricanteNovoRequest;
import br.org.curitiba.ici.saude.person.rest.web.request.FabricantePesquisaRequest;
import br.org.curitiba.ici.saude.person.rest.web.response.FabricantePesquisaResponse;
import br.org.curitiba.ici.saude.person.rest.web.response.FabricanteResponse;
import br.org.curitiba.ici.saude.person.services.FabricanteService;
/*
import br.org.curitiba.ici.saude.common.PageResponse;
import br.org.curitiba.ici.saude.common.PaginationRequest;

import br.org.curitiba.ici.saude.medicamento.rest.mapper.FabricanteMapper;
import br.org.curitiba.ici.saude.medicamento.rest.web.request.FabricanteAtualizacaoRequest;
import br.org.curitiba.ici.saude.medicamento.rest.web.request.FabricanteNovoRequest;
import br.org.curitiba.ici.saude.medicamento.rest.web.request.FabricantePesquisaRequest;
import br.org.curitiba.ici.saude.medicamento.rest.web.response.FabricantePesquisaResponse;
import br.org.curitiba.ici.saude.medicamento.rest.web.response.FabricanteResponse;
import br.org.curitiba.ici.saude.medicamento.service.FabricanteService;
*/
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("medicamentos/fabricantes")
public class FabricanteController {
  private final FabricanteService fabricanteService;
  private final FabricanteMapper fabricanteMapper;
  @ResponseStatus(value = HttpStatus.CREATED)
  @PostMapping
  public Integer salvar(@RequestBody @Valid FabricanteNovoRequest request) {
    return fabricanteService.salvar(fabricanteMapper.toEntity(request)).getCdFabricante();
  }

  @PutMapping(path = "/{id}")
  public void atualizar(@RequestBody @Valid FabricanteAtualizacaoRequest request,
      @NotNull @PathVariable("id") Integer id) {
    fabricanteService.salvar(fabricanteMapper.toEntity(fabricanteService.buscarPorIdOuThrow(id), request));
  }

  @GetMapping(path = "/{id}")
  public FabricanteResponse buscarPorId(@NotNull @PathVariable("id") Integer id) {
    return fabricanteMapper.toResponse(fabricanteService.buscarPorIdOuThrow(id));
  }

  @DeleteMapping(path = "/{id}")
  public void deletar(@NotNull @PathVariable("id") Integer id) {
    fabricanteService.deletarPorId(id);
  }

  @GetMapping
  public PageResponse<FabricantePesquisaResponse> pesquisar(FabricantePesquisaRequest request,
      PaginationRequest paginationRequest) {
    return fabricanteMapper.toResponse(
        fabricanteService.pesquisarView(paginationRequest.toPageable(), request.toParametros()));
  }

}

