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



                        


public interface PessoaRepository
    extends JpaRepository<PessoaEntity, Integer> {
  @Override
  @Query(value = """
          select e
          from Pessoa e
          where e.cdPessoa = ?1
      """)
  public Optional<PessoaEntity> findById(Integer cdPessoa);
}
