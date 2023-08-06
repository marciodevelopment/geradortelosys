package org.demo.repositories;
import org.demo.entities.Fabricante;

import java.util.Map;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import br.org.curitiba.ici.saude.common.query.QuerySearch;
import br.org.curitiba.ici.saude.common.query.SearchRepository;


                                                                                                                


public interface FabricanteRepository
    extends JpaRepository<FabricanteEntity, Integer>, SearchRepository<FabricantePesquisaView> {
  @QuerySearch(columns = "colunasPesquisa", query = """
      from Fabricante e
      where  1 = 1
      and cdFabricante = :cdFabricante
                """, viewResult = FabricantePesquisaView.class)
  @Override
  public Page<FabricantePesquisaView> search(Map<String, Object> parameters, Pageable pageable);

  @Override
  @Query(value = """
          select e
          from Fabricante e
          where e.cdFabricante = ?1
      """)
  public Optional<FabricanteEntity> findById(Integer cdFabricante);
}
