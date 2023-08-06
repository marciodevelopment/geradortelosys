package org.demo.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.demo.repositories.PessoaRepository;
import org.demo.entities.Pessoa;
import org.demo.service.PessoaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Map;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;


import java.util.Collections;
import java.util.List;



        			            			            			
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

