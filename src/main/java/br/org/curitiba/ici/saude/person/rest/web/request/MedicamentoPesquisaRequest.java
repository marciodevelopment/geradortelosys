package br.org.curitiba.ici.saude.person.rest.web.request;

import br.org.curitiba.ici.saude.common.ParametrosPesquisaRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


                        

@NoArgsConstructor
@Setter
@Getter
public class MedicamentoPesquisaRequest extends ParametrosPesquisaRequest {
  private String     nmMedicamento ;

}
