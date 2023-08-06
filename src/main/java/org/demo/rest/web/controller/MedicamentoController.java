


                	    	    	            		    	
package org.demo.rest.web.controller;

import org.demo.entities.Medicamento;
import org.demo.service.MedicamentoService;

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
/*
import br.org.curitiba.ici.saude.common.PageResponse;
import br.org.curitiba.ici.saude.common.PaginationRequest;

import br.org.curitiba.ici.saude.medicamento.rest.mapper.MedicamentoMapper;
import br.org.curitiba.ici.saude.medicamento.rest.web.request.MedicamentoAtualizacaoRequest;
import br.org.curitiba.ici.saude.medicamento.rest.web.request.MedicamentoNovoRequest;
import br.org.curitiba.ici.saude.medicamento.rest.web.request.MedicamentoPesquisaRequest;
import br.org.curitiba.ici.saude.medicamento.rest.web.response.MedicamentoPesquisaResponse;
import br.org.curitiba.ici.saude.medicamento.rest.web.response.MedicamentoResponse;
import br.org.curitiba.ici.saude.medicamento.service.MedicamentoService;
*/
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("medicamentos")
public class MedicamentoController {
  private final MedicamentoService medicamentoService;
  private final MedicamentoMapper medicamentoMapper;
  @ResponseStatus(value = HttpStatus.CREATED)
  @PostMapping
  public Integer salvar(@RequestBody @Valid MedicamentoNovoRequest request) {
    return medicamentoService.salvar(medicamentoMapper.toEntity(request)).getCdMedicamento();
  }

  @PutMapping(path = "/{id}")
  public void atualizar(@RequestBody @Valid MedicamentoAtualizacaoRequest request,
      @NotNull @PathVariable("id") Integer id) {
    medicamentoService.salvar(medicamentoMapper.toEntity(medicamentoService.buscarPorIdOuThrow(id), request));
  }

  @GetMapping(path = "/{id}")
  public MedicamentoResponse buscarPorId(@NotNull @PathVariable("id") Integer id) {
    return medicamentoMapper.toResponse(medicamentoService.buscarPorIdOuThrow(id));
  }

  @DeleteMapping(path = "/{id}")
  public void deletar(@NotNull @PathVariable("id") Integer id) {
    medicamentoService.deletarPorId(id);
  }

  @GetMapping
  public PageResponse<MedicamentoPesquisaResponse> pesquisar(MedicamentoPesquisaRequest request,
      PaginationRequest paginationRequest) {
    return medicamentoMapper.toResponse(
        medicamentoService.pesquisarView(paginationRequest.toPageable(), request.toParametros()));
  }

}

