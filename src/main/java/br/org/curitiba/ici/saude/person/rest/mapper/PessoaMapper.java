package br.org.curitiba.ici.saude.person.rest.mapper;

import org.mapstruct.Mapper;
import br.org.curitiba.ici.saude.person.entities.PessoaEntity;
import br.org.curitiba.ici.saude.person.rest.web.response.PessoaResponse;



        			            			            			

@Mapper(componentModel = "spring",
    implementationPackage = "br.org.curitiba.ici.saude.person.rest.mapper.impl")
public abstract class PessoaMapper {
  public abstract PessoaResponse toResponse(PessoaEntity pessoa);

}
