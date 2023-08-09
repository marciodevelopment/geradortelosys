package br.org.curitiba.ici.saude.person.entities.view;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.*;
import jakarta.validation.*;
import br.org.curitiba.ici.saude.common.*;
import br.org.curitiba.ici.saude.*;


                                            

@NoArgsConstructor
@Data
public class MedicamentoPesquisaView {
  private String     nmMedicamento ;
  private Integer    cdFabricante ;

}
