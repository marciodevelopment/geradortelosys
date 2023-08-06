package org.demo.repositories;
import org.demo.entities.Medicamento;

import java.util.Map;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import br.org.curitiba.ici.saude.common.query.QuerySearch;
import br.org.curitiba.ici.saude.common.query.SearchRepository;


                                    


public interface MedicamentoRepository
    extends JpaRepository<MedicamentoEntity, Integer>, SearchRepository<MedicamentoPesquisaView> {
  @QuerySearch(columns = "colunasPesquisa", query = """
      from Medicamento e
      where  1 = 1
      and cdMedicamento = :cdMedicamento
                """, viewResult = MedicamentoPesquisaView.class)
  @Override
  public Page<MedicamentoPesquisaView> search(Map<String, Object> parameters, Pageable pageable);

  @Override
  @Query(value = """
          select e
          from Medicamento e
          where e.cdMedicamento = ?1
      """)
  public Optional<MedicamentoEntity> findById(Integer cdMedicamento);
}
