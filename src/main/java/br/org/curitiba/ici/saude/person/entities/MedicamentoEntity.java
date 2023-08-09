
package br.org.curitiba.ici.saude.person.entities;



import java.io.Serializable;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import br.org.curitiba.ici.saude.common.entity.type.SituacaoType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;


/**
 * JPA entity class for "Medicamento"
 *
 * @author Telosys
 *
 */

@Where(clause = " idSituacao <> 0 ")
@SQLDelete(sql = "UPDATE Medicamento SET idSituacao = 0 WHERE cdMedicamento = ? ")
@Accessors(chain = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "MEDICAMENTO")
public class MedicamentoEntity implements Serializable {
  private static final long serialVersionUID = 1L;

  @Getter
  @Id
  @Column(name = "cd_medicamento", nullable = false)
  private int cdMedicamento;

  @Getter
  @Size(min = 5, max = 255, message = "Nome Medicamento")
  private String nmMedicamento;
  @NotNull(message = "Situação")
  private SituacaoType idSituacao;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "cdfabricante", referencedColumnName = "cd_fabricante", insertable = false,
      updatable = false)
  @Getter
  @NotNull(message = "Fabricante")
  private FabricanteEntity fabricante;


  public MedicamentoEntity(String nmMedicamento, FabricanteEntity fabricante) {
    this.nmMedicamento = nmMedicamento;
    this.fabricante = fabricante;
    this.idSituacao = SituacaoType.ATIVO;
  }


  public MedicamentoEntity atualizar(String nmMedicamento, FabricanteEntity fabricante) {
    this.nmMedicamento = nmMedicamento;
    this.fabricante = fabricante;
    return this;
  }

}
