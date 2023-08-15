package br.org.curitiba.ici.saude.usuario.repositories;

import java.util.Map;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import br.org.curitiba.ici.saude.common.query.QuerySearch;
import br.org.curitiba.ici.saude.common.query.SearchRepository;
import br.org.curitiba.ici.saude.usuario.entities.GeneroEntity;
import br.org.curitiba.ici.saude.usuario.entities.view.GeneroPesquisaView;



public interface GeneroRepository
    extends JpaRepository<GeneroEntity, Integer>, SearchRepository<GeneroPesquisaView> {
  @QuerySearch(columns = "e.cdGenero, e.dsGenero", query = """
          from GeneroEntity e
          where  1 = 1
          and e.cdGenero = :cdGenero
          and e.dsGenero = :dsGenero
      """, viewResult = GeneroPesquisaView.class)
  @Override
  public Page<GeneroPesquisaView> search(Map<String, Object> parameters, Pageable pageable);

}
