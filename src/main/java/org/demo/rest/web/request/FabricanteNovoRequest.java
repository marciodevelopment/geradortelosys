package org.demo.rest.web.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;


                                                                                    

@NoArgsConstructor
@Setter
@Data
public class FabricanteAtualizacaoRequest {
  @Size( min = 1, max = 255 , message="Nome Fabricante")
  private String     nmFabricante ;
  @NotNull(message="Origem")
  private OrigemType idOrigem; 
  private String     nmSigla ;
  @Size( min = 1, max = 255 , message="")
  private String     nmCidadeFabricante ;

}
