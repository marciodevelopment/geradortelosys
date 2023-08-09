package br.org.curitiba.ici.saude.person.rest.web.requests;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;
import jakarta.validation.*;
import br.org.curitiba.ici.saude.common.*;
import br.org.curitiba.ici.saude.*;


                                                    

@NoArgsConstructor
@Setter
@Getter
public class FabricantePesquisaRequest extends ParametrosPesquisaRequest {
  private String     nmFabricante ;
  private OrigemType idOrigem; 

}
