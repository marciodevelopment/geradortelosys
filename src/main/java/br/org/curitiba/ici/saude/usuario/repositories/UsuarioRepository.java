package br.org.curitiba.ici.saude.usuario.repositories;

import java.util.Map;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import br.org.curitiba.ici.saude.common.query.QuerySearch;
import br.org.curitiba.ici.saude.common.query.SearchRepository;
import br.org.curitiba.ici.saude.usuario.entities.UsuarioEntity;
import br.org.curitiba.ici.saude.usuario.entities.view.UsuarioPesquisaView;



public interface UsuarioRepository
    extends JpaRepository<UsuarioEntity, Integer>, SearchRepository<UsuarioPesquisaView> {
  @QuerySearch(columns = "e.cdUsuario, e.nmUsuario, e.nmMae, e.idSexo", query = """
      from UsuarioEntity e
      where  1 = 1
      and e.cdUsuario = :cdUsuario
      and e.nmUsuario = :nmUsuario
      and e.nmMae = :nmMae
      and e.idSexo = :idSexo
          """, viewResult = UsuarioPesquisaView.class)
  @Override
  public Page<UsuarioPesquisaView> search(Map<String, Object> parameters, Pageable pageable);

}
