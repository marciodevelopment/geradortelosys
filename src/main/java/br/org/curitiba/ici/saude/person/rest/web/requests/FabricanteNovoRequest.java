package br.org.curitiba.ici.saude.person.rest.web.requests;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.*;
import jakarta.validation.*;
import br.org.curitiba.ici.saude.common.*;
import jakarta.validation.constraints.*;
import br.org.curitiba.ici.saude.*;


                                                                                    

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
