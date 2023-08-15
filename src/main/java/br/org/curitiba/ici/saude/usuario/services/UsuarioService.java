package br.org.curitiba.ici.saude.usuario.services;


import java.util.Map;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.org.curitiba.ici.saude.usuario.entities.UsuarioEntity;
import br.org.curitiba.ici.saude.usuario.entities.view.UsuarioPesquisaView;
import br.org.curitiba.ici.saude.usuario.repositories.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;



@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class UsuarioService {
  private final UsuarioRepository usuarioRepository;

  @Transactional
  public UsuarioEntity salvar(UsuarioEntity usuario) {
    return usuarioRepository.save(usuario);
  }

  @Transactional
  public void deletarPorId(Integer cdUsuario) {
    usuarioRepository.deleteById(cdUsuario);
  }

  public UsuarioEntity buscarPorIdOuThrow(Integer cdUsuario) {
    return usuarioRepository.findById(cdUsuario).orElseThrow(() -> new EntityNotFoundException(
        "Usuario não encontrado para o código enviado %s".formatted(cdUsuario)));
  }

  public Page<UsuarioPesquisaView> pesquisarView(Pageable pageable,
      Map<String, Object> parametros) {
    return usuarioRepository.search(parametros, pageable);
  }

}

