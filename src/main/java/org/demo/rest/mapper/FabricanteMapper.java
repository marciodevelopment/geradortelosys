package org.demo.rest.mapper;

import java.util.Collection;
import java.util.stream.Stream;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;
import br.org.curitiba.ici.saude.common.PageResponse;

import java.util.Collections;
import java.util.List;



                	    	    	            		    	                	    	    	                    		    	                    		    	    

@Mapper(componentModel = "spring",
    implementationPackage = "org.demo.rest.mapper.impl")
public abstract class FabricanteMapper {
  public FabricanteEntity toEntity(FabricanteNovoRequest request) {
   // TODO: implementar
	return null;
  }

  public FabricanteEntity toEntity(FabricanteEntity fabricante, FabricanteAtualizacaoRequest request) {
    // TODO: implementar
	return null;
  }

  public abstract FabricanteResponse toResponse(FabricanteEntity fabricante);

  public abstract Collection<FabricantePesquisaResponse> toResponse(
      Stream<FabricantePesquisaView> fabricantes);
      
  public PageResponse<FabricantePesquisaResponse> toResponse(Page<FabricantePesquisaView> resultadosPesquisa) {
    return new PageResponse<>(this.toResponse(resultadosPesquisa.get()), resultadosPesquisa);
  }

}
