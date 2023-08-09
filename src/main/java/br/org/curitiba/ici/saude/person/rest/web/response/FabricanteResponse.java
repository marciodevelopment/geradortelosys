package br.org.curitiba.ici.saude.person.rest.web.response;

import br.org.curitiba.ici.saude.person.entities.types.OrigemType;
import lombok.Data;
import lombok.NoArgsConstructor;


                                                                                                        

@NoArgsConstructor
@Data
public class FabricanteResponse {
  private Integer    cdFabricante ;
  private String     nmFabricante ;
  private OrigemType idOrigem; 
  private String     nmSigla ;
  private String     nmCidadeFabricante ;

}
