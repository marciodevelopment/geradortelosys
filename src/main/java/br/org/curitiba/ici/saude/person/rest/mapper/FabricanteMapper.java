package br.org.curitiba.ici.saude.person.rest.mapper;

import java.util.Collection;
import java.util.stream.Stream;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;
import br.org.curitiba.ici.saude.common.PageResponse;
import br.org.curitiba.ici.saude.person.entities.FabricanteEntity;
import br.org.curitiba.ici.saude.person.entities.view.FabricantePesquisaView;
import br.org.curitiba.ici.saude.person.rest.web.request.FabricanteAtualizacaoRequest;
import br.org.curitiba.ici.saude.person.rest.web.request.FabricanteNovoRequest;
import br.org.curitiba.ici.saude.person.rest.web.response.FabricantePesquisaResponse;
import br.org.curitiba.ici.saude.person.rest.web.response.FabricanteResponse;



                	    	    	            		    	                	    	    	                    		    	                    		    	    

@Mapper(componentModel = "spring",
    implementationPackage = "br.org.curitiba.ici.saude.person.rest.mapper.impl")
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
