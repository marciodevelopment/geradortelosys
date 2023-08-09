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
public class FabricanteService {
  private final FabricanteRepository fabricanteRepository;

  @Transactional
  public FabricanteEntity salvar(FabricanteEntity fabricante) {
    return fabricanteRepository.save(fabricante);
  }

  @Transactional
  public void deletarPorId(Integer cdFabricante) {
    fabricanteRepository.deleteById(cdFabricante);
  }

  public FabricanteEntity buscarPorIdOuThrow(Integer cdFabricante) {
    return fabricanteRepository.findById(cdFabricante).orElseThrow(() -> new EntityNotFoundException(
        "Fabricante não encontrado para o código enviado %s".formatted(cdFabricante)));
  }

  public Page<FabricantePesquisaView> pesquisarView(Pageable pageable,
      Map<String, Object> parametros) {
    return fabricanteRepository.search(parametros, pageable);
  }

}

