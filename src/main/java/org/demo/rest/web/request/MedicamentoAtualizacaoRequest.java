package org.demo.rest.web.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;


                        

@NoArgsConstructor
@Setter
@Data
public class MedicamentoAtualizacaoRequest {
  @Size( min = 5, max = 255 , message="Nome Medicamento")
  private String     nmMedicamento ;

}
