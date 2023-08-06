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
public abstract class MedicamentoMapper {
  public MedicamentoEntity toEntity(MedicamentoNovoRequest request) {
   // TODO: implementar
	return null;
  }

  public MedicamentoEntity toEntity(MedicamentoEntity medicamento, MedicamentoAtualizacaoRequest request) {
    // TODO: implementar
	return null;
  }

  public abstract MedicamentoResponse toResponse(MedicamentoEntity medicamento);

  public abstract Collection<MedicamentoPesquisaResponse> toResponse(
      Stream<MedicamentoPesquisaView> medicamentos);
      
  public PageResponse<MedicamentoPesquisaResponse> toResponse(Page<MedicamentoPesquisaView> resultadosPesquisa) {
    return new PageResponse<>(this.toResponse(resultadosPesquisa.get()), resultadosPesquisa);
  }

}
