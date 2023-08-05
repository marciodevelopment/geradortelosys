package org.demo.medicamento.entities;

                        




import java.io.Serializable;
import javax.persistence.*;

/**
 * JPA entity class for "Medicamento"
 *
 * @author Telosys
 *
 */


@Where(clause = " idSituacao <> 0 ")
@SQLDelete(sql = "UPDATE Fabricante SET idSituacao = 0 WHERE cdFabricante = ? ")

@Accessors(chain = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name="MEDICAMENTO" )
public class MedicamentoEntity implements Serializable {
  private static final long serialVersionUID = 1L;

	  @Id
  @Column(name="cd_medicamento", nullable=false)
    private int        cdMedicamento ;
     
    @Getter
      @Size( min = 5, max = 255 , message="Nome Medicamento")
  private String     nmMedicamento ;

    @NotNull(message="Situação")
  private SituacaoType idSituacao; 


                            
  public MedicamentoEntity (String     nmMedicamento) {
    this.nmMedicamento = nmMedicamento;
    this.idSituacao = SituacaoType.Ativo;
  }

                        

  public MedicamentoEntity atualizar (String     nmMedicamento) {
    this.nmMedicamento = nmMedicamento;
    return this;
  }
    //--- ENTITY LINKS ( RELATIONSHIP )

    
    //--- GETTERS FOR LINKS
}