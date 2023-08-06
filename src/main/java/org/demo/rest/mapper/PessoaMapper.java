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
public abstract class PessoaMapper {
  public abstract PessoaResponse toResponse(PessoaEntity pessoa);

}
