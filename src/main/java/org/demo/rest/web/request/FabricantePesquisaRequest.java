package org.demo.rest.web.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;


                                                    

@NoArgsConstructor
@Setter
@Data
public class FabricanteAtualizacaoRequest {
  private String     nmFabricante ;
  private OrigemType idOrigem; 

}
