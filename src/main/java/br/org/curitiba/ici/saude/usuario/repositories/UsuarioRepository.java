package br.org.curitiba.ici.saude.usuario.repositories;

import java.util.Map;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import br.org.curitiba.ici.saude.common.query.QuerySearch;
import br.org.curitiba.ici.saude.common.query.SearchRepository;
import br.org.curitiba.ici.saude.usuario.entities.UsuarioEntity;
import br.org.curitiba.ici.saude.usuario.entities.view.UsuarioPesquisaView;



public interface UsuarioRepository
    extends JpaRepository<UsuarioEntity, Integer>, SearchRepository<UsuarioPesquisaView> {
  @QuerySearch(columns = "colunasPesquisa", query = """
      from Usuario e
      where  1 = 1
      and cdUsuario = :cdUsuario
                """, viewResult = UsuarioPesquisaView.class)
  @Override
  public Page<UsuarioPesquisaView> search(Map<String, Object> parameters, Pageable pageable);

  @Override
  @Query(value = """
          select e
          from Usuario e
          where e.cdUsuario = ?1
      """)
  public Optional<UsuarioEntity> findById(Integer cdUsuario);
}
