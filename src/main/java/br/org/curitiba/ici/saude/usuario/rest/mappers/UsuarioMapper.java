package br.org.curitiba.ici.saude.usuario.rest.mappers;

import java.util.Collection;
import java.util.stream.Stream;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;
import br.org.curitiba.ici.saude.common.PageResponse;
import br.org.curitiba.ici.saude.usuario.entities.UsuarioEntity;
import br.org.curitiba.ici.saude.usuario.entities.view.UsuarioPesquisaView;
import br.org.curitiba.ici.saude.usuario.rest.web.requests.UsuarioAtualizacaoRequest;
import br.org.curitiba.ici.saude.usuario.rest.web.requests.UsuarioNovoRequest;
import br.org.curitiba.ici.saude.usuario.rest.web.responses.UsuarioPesquisaResponse;
import br.org.curitiba.ici.saude.usuario.rest.web.responses.UsuarioResponse;

@Mapper(componentModel = "spring",
    implementationPackage = "br.org.curitiba.ici.saude.usuario.rest.mappers.impl")
public abstract class UsuarioMapper {
  public UsuarioEntity toEntity(UsuarioNovoRequest request) {
    return new UsuarioEntity(request.getNmUsuario(), request.getNmMae(), request.getIdSexo())
        .setNmPai(request.getNmPai());
  }

  public UsuarioEntity toEntity(UsuarioEntity usuario, UsuarioAtualizacaoRequest request) {
    usuario.atualizar(request.getNmUsuario(), request.getNmMae(), request.getIdSexo())
        .setNmPai(request.getNmPai());
    return usuario;
  }

  public abstract UsuarioResponse toResponse(UsuarioEntity usuario);

  public abstract Collection<UsuarioPesquisaResponse> toResponse(
      Stream<UsuarioPesquisaView> usuarios);

  public PageResponse<UsuarioPesquisaResponse> toResponse(
      Page<UsuarioPesquisaView> resultadosPesquisa) {
    return new PageResponse<>(this.toResponse(resultadosPesquisa.get()), resultadosPesquisa);
  }

}
