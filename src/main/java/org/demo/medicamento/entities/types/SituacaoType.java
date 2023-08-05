package org.demo.medicamento.entities.types;

import lombok.Getter;


      
@Getter
public enum SituacaoType {
  ATIVO(1, "Ativo"),
    INATIVO(0, "Inativo");

  private final int id;
  private final String description;

  private SituacaoType(int id, String description) {
    this.id = id;
    this.description = description;
  }

  public static SituacaoType toType(Integer id) {
    return EnumUtil.toType(id, SituacaoType.class);
  }
}