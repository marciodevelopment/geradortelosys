
package br.org.curitiba.ici.saude.person.entities;

                                                    
        
    
  

                        
import java.io.Serializable;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import br.org.curitiba.ici.saude.*;
import br.org.curitiba.ici.saude.*;


import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import java.util.Set;
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

   @Getter
     @Id
  @Column(name="cd_fabricante", nullable=false)
   private int        cdFabricante ;

               @Getter
                     @Size( min = 1, max = 255 , message="Nome Fabricante")
        private String     nmFabricante;
                          @NotNull(message="Situação")
        private SituacaoType idSituacao; 
                     @Getter
                     @NotNull(message="Origem")
        private OrigemType idOrigem; 
                     @Getter
          @Setter 
                 private String     nmSigla;
                     @Getter
                     @Size( min = 1, max = 255 , message="")
        private String     nmCidadeFabricante;
      
    @OneToMany(fetch = FetchType.LAZY, mappedBy="fabricante")
            private Set<MedicamentoEntity> medicamentos ; 

                                                                        
  public FabricanteEntity (  String nmFabricante,   OrigemType  idOrigem,   String nmCidadeFabricante  ){
this.nmFabricante = nmFabricante;
this.idOrigem = idOrigem;
this.nmCidadeFabricante = nmCidadeFabricante;
    this.idSituacao = SituacaoType.ATIVO;
  }

                                                                                    
  public FabricanteEntity atualizar(  String nmFabricante,   OrigemType  idOrigem,   String nmCidadeFabricante  ) {
this.nmFabricante = nmFabricante;
this.idOrigem = idOrigem;
this.nmCidadeFabricante = nmCidadeFabricante;
   return this;
  }

}