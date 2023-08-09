package br.org.curitiba.ici.saude.person.rest.web.request;

import jakarta.validation.constraints.Size;
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
