package org.demo.medicamento.entities;

                                                    






import java.io.Serializable;
import javax.persistence.*;

/**
 * JPA entity class for "Fabricante"
 *
 * @author Telosys
 *
 */


@Where(clause = " idSituacao <> 0 ")
@SQLDelete(sql = "UPDATE Fabricante SET idSituacao = 0 WHERE cdFabricante = ? ")

@Accessors(chain = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name="FABRICANTE" )
public class FabricanteEntity implements Serializable {
  private static final long serialVersionUID = 1L;

	  @Id
  @Column(name="cd_fabricante", nullable=false)
    private int        cdFabricante ;
     
    @Getter
      @Size( min = 1, max = 255 , message="Nome Fabricante")
  private String     nmFabricante ;

    @NotNull(message="Situação")
  private SituacaoType idSituacao; 

    @NotNull(message="Origem")
  private OrigemType idOrigem; 

    @Getter
    @Setter 
  private String     nmSigla ;

    @Getter
      @Size( min = 1, max = 255 , message="")
  private String     nmCidadeFabricante ;


                                                                                        
  public FabricanteEntity (String     nmFabricante,Integer    idOrigem,String     nmSigla,String     nmCidadeFabricante) {
    this.nmFabricante = nmFabricante;
    this.idOrigem = idOrigem;
    this.nmSigla = nmSigla;
    this.nmCidadeFabricante = nmCidadeFabricante;
    this.idSituacao = SituacaoType.Ativo;
  }

                                                                    

  public FabricanteEntity atualizar (String     nmFabricante,String     nmSigla,String     nmCidadeFabricante) {
    this.nmFabricante = nmFabricante;
    this.nmSigla = nmSigla;
    this.nmCidadeFabricante = nmCidadeFabricante;
    return this;
  }
    //--- ENTITY LINKS ( RELATIONSHIP )

    
    //--- GETTERS FOR LINKS
}