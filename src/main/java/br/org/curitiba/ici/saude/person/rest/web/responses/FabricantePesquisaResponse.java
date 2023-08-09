package br.org.curitiba.ici.saude.person.rest.web.responses;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.*;
import jakarta.validation.*;
import br.org.curitiba.ici.saude.common.*;
import br.org.curitiba.ici.saude.*;


                                                    

@NoArgsConstructor
@Data
public class FabricantePesquisaResponse {
  private String     nmFabricante ;
  private OrigemType idOrigem; 

}
