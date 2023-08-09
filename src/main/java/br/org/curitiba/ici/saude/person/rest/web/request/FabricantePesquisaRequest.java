package br.org.curitiba.ici.saude.person.rest.web.request;

import br.org.curitiba.ici.saude.common.ParametrosPesquisaRequest;
import br.org.curitiba.ici.saude.person.entities.types.OrigemType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


                                                    

@NoArgsConstructor
@Setter
@Getter
public class FabricantePesquisaRequest extends ParametrosPesquisaRequest {
  private String     nmFabricante ;
  private OrigemType idOrigem; 

}
