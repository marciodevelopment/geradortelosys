package org.demo.repositories;
import org.demo.entities.Pessoa;

import java.util.Map;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import br.org.curitiba.ici.saude.common.query.QuerySearch;
import br.org.curitiba.ici.saude.common.query.SearchRepository;


                        


public interface PessoaRepository
    extends JpaRepository<PessoaEntity, Integer>, SearchRepository<PessoaPesquisaView> {
  @Override
  @Query(value = """
          select e
          from Pessoa e
          where e.cdPessoa = ?1
      """)
  public Optional<PessoaEntity> findById(Integer cdPessoa);
}
