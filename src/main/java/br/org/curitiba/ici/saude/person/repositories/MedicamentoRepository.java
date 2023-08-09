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
