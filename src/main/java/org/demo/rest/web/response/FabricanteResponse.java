package org.demo.rest.web.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;


                                                                                                        

@NoArgsConstructor
@Data
public class FabricanteAtualizacaoResponse {
  private Integer    cdFabricante ;
  private String     nmFabricante ;
  private OrigemType idOrigem; 
  private String     nmSigla ;
  private String     nmCidadeFabricante ;

}
