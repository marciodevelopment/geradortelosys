package org.demo.entities;

import java.io.Serializable;
import javax.persistence.*;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * JPA entity class for "Fabricante"
 *
 * @author Telosys
 *
 */


@Accessors(chain = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "FABRICANTE")
public class FabricanteEntity implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "cd_fabricante", nullable = false)
  private int cdFabricante;

  @Getter
  @Size(min = 1, max = 255, message = "Nome Fabricante")
  private String nmFabricante;

  @NotNull(message = "Situação")
  private SituacaoType idSituacao;

  @Getter
  @Setter
  private String nmSigla;

  @Getter
  @Size(min = 1, max = 255, message = "")
  private String nmCidadeFabricante;



  public FabricanteEntity(String nmFabricante, String nmSigla, String nmCidadeFabricante) {
    this.nmFabricante = nmFabricante;
    this.nmSigla = nmSigla;
    this.nmCidadeFabricante = nmCidadeFabricante;
    this.idSituacao = SituacaoType.Ativo;
  }



  public FabricanteEntity atualizar(String nmFabricante, String nmSigla,
      String nmCidadeFabricante) {
    this.nmFabricante = nmFabricante;
    this.nmSigla = nmSigla;
    this.nmCidadeFabricante = nmCidadeFabricante;
    return this;
  }
  // --- ENTITY LINKS ( RELATIONSHIP )


  // --- GETTERS FOR LINKS
}
