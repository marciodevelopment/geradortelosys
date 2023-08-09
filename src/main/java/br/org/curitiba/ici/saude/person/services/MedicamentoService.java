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
public class MedicamentoService {
  private final MedicamentoRepository medicamentoRepository;

  @Transactional
  public MedicamentoEntity salvar(MedicamentoEntity medicamento) {
    return medicamentoRepository.save(medicamento);
  }

  @Transactional
  public void deletarPorId(Integer cdMedicamento) {
    medicamentoRepository.deleteById(cdMedicamento);
  }

  public MedicamentoEntity buscarPorIdOuThrow(Integer cdMedicamento) {
    return medicamentoRepository.findById(cdMedicamento).orElseThrow(() -> new EntityNotFoundException(
        "Medicamento não encontrado para o código enviado %s".formatted(cdMedicamento)));
  }

  public Page<MedicamentoPesquisaView> pesquisarView(Pageable pageable,
      Map<String, Object> parametros) {
    return medicamentoRepository.search(parametros, pageable);
  }

}

