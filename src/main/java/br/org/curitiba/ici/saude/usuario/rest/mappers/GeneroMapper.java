package br.org.curitiba.ici.saude.usuario.rest.mappers;

import java.util.Collection;
import java.util.stream.Stream;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;
import br.org.curitiba.ici.saude.common.PageResponse;
import br.org.curitiba.ici.saude.usuario.entities.GeneroEntity;
import br.org.curitiba.ici.saude.usuario.entities.view.GeneroPesquisaView;
import br.org.curitiba.ici.saude.usuario.rest.web.requests.GeneroAtualizacaoRequest;
import br.org.curitiba.ici.saude.usuario.rest.web.requests.GeneroNovoRequest;
import br.org.curitiba.ici.saude.usuario.rest.web.responses.GeneroPesquisaResponse;
import br.org.curitiba.ici.saude.usuario.rest.web.responses.GeneroResponse;
import br.org.curitiba.ici.saude.usuario.services.GeneroService;

@Mapper(componentModel = "spring",
    implementationPackage = "br.org.curitiba.ici.saude.usuario.rest.mappers.impl")
public abstract class GeneroMapper {
  private GeneroService generoService;

  public GeneroEntity toEntity(GeneroNovoRequest request) {
    return new GeneroEntity(request.getDsGenero()).setSgGenero(request.getSgGenero());
  }

  public GeneroEntity toEntity(GeneroEntity genero, GeneroAtualizacaoRequest request) {
    genero.atualizar(request.getDsGenero()).setSgGenero(request.getSgGenero());
    return genero;
  }

  public abstract GeneroResponse toResponse(GeneroEntity genero);

  public abstract Collection<GeneroPesquisaResponse> toResponse(Stream<GeneroPesquisaView> generos);

  public PageResponse<GeneroPesquisaResponse> toResponse(
      Page<GeneroPesquisaView> resultadosPesquisa) {
    return new PageResponse<>(this.toResponse(resultadosPesquisa.get()), resultadosPesquisa);
  }

}
