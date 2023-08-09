package br.org.curitiba.ici.saude.person.repositories;

import java.util.*;
import org.springframework.data.*;
import java.io.Serializable;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import br.org.curitiba.ici.saude.common.*;
import br.org.curitiba.ici.saude.*;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.*;



                                                                                                                


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
