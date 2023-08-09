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
public class MedicamentoNovoRequest {
  @Size( min = 5, max = 255 , message="Nome Medicamento")
  private String     nmMedicamento ;
  @NotNull(message="Fabricante")
  private Integer    cdFabricante ;

}
