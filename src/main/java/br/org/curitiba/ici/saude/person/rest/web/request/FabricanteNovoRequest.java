package br.org.curitiba.ici.saude.person.rest.web.request;

import br.org.curitiba.ici.saude.person.entities.types.OrigemType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;


                                                                                    

@NoArgsConstructor
@Setter
@Data
public class FabricanteNovoRequest {
  @Size( min = 1, max = 255 , message="Nome Fabricante")
  private String     nmFabricante ;
  @NotNull(message="Origem")
  private OrigemType idOrigem; 
  private String     nmSigla ;
  @Size( min = 1, max = 255 , message="")
  private String     nmCidadeFabricante ;

}
