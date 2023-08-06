package org.demo.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.demo.repositories.FabricanteRepository;
import org.demo.entities.Fabricante;
import org.demo.service.FabricanteService;
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

