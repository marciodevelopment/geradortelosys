


package br.org.curitiba.ici.saude.usuario.rest.web.controllers;

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
import br.org.curitiba.ici.saude.usuario.rest.mappers.GeneroMapper;
import br.org.curitiba.ici.saude.usuario.rest.web.requests.GeneroAtualizacaoRequest;
import br.org.curitiba.ici.saude.usuario.rest.web.requests.GeneroNovoRequest;
import br.org.curitiba.ici.saude.usuario.rest.web.requests.GeneroPesquisaRequest;
import br.org.curitiba.ici.saude.usuario.rest.web.responses.GeneroPesquisaResponse;
import br.org.curitiba.ici.saude.usuario.rest.web.responses.GeneroResponse;
import br.org.curitiba.ici.saude.usuario.services.GeneroService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("generos")
public class GeneroController {
  private final GeneroService generoService;
  private final GeneroMapper generoMapper;

  @ResponseStatus(value = HttpStatus.CREATED)
  @PostMapping
  public Integer salvar(@RequestBody @Valid GeneroNovoRequest request) {
    return generoService.salvar(generoMapper.toEntity(request)).getCdGenero();
  }

  @PutMapping(path = "/{id}")
  public void atualizar(@RequestBody @Valid GeneroAtualizacaoRequest request,
      @NotNull @PathVariable("id") Integer id) {
    generoService.salvar(generoMapper.toEntity(generoService.buscarPorIdOuThrow(id), request));
  }

  @GetMapping(path = "/{id}")
  public GeneroResponse buscarPorId(@NotNull @PathVariable("id") Integer id) {
    return generoMapper.toResponse(generoService.buscarPorIdOuThrow(id));
  }

  @DeleteMapping(path = "/{id}")
  public void deletar(@NotNull @PathVariable("id") Integer id) {
    generoService.deletarPorId(id);
  }

  @GetMapping
  public PageResponse<GeneroPesquisaResponse> pesquisar(GeneroPesquisaRequest request,
      PaginationRequest paginationRequest) {
    return generoMapper.toResponse(
        generoService.pesquisarView(paginationRequest.toPageable(), request.toParametros()));
  }

}

