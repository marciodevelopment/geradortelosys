
package org.demo.medicamento.entities;

                            
  

                
import java.io.Serializable;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import javax.persistence.*;

/**
 * JPA entity class for "Pessoa"
 *
 * @author Telosys
 *
 */

@Where(clause = " idSituacao <> 0 ")
@SQLDelete(sql = "UPDATE Pessoa SET idSituacao = 0 WHERE cdPessoa = ? ")
@Accessors(chain = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name="PESSOA" )
public class PessoaEntity implements Serializable {
  private static final long serialVersionUID = 1L;

	  @Id
  @Column(name="cd_pessoa", nullable=false)
    private int        cdPessoa ;
     
    @Getter
      @Size( min = 5, max = 255 , message="Nome Pessoa")
  private String     nmPessoa ;

    @Getter
      @Size( min = 5, max = 255 , message="Nome Mae")
  private String     nmMae ;

    @NotNull(message="Situação")
  private SituacaoType idSituacao; 



                                                
  public PessoaEntity (String    
nmPessoa,String    
nmMae) {
    this.nmPessoa = nmPessoa;
    this.nmMae = nmMae;
    this.idSituacao = SituacaoType.ATIVO;
  }

            


}