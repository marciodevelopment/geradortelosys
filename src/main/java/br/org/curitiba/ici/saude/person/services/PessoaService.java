package br.org.curitiba.ici.saude.person.services;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Map;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;


import java.util.Collections;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.*;
import br.org.curitiba.ici.saude.common.*;
import br.org.curitiba.ici.saude.*;



        			            			            			
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class PessoaService {
  private final PessoaRepository pessoaRepository;

  public PessoaEntity buscarPorIdOuThrow(Integer cdPessoa) {
    return pessoaRepository.findById(cdPessoa).orElseThrow(() -> new EntityNotFoundException(
        "Pessoa não encontrado para o código enviado %s".formatted(cdPessoa)));
  }

}

