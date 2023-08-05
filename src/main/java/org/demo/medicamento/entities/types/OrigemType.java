package org.demo.medicamento.entities.types;

import lombok.Getter;


            
@Getter
public enum OrigemType {
  NACIONAL(1, "Nacional"),
    IMPORTADO(2, "Importado");

  private final int id;
  private final String description;

  private OrigemType(int id, String description) {
    this.id = id;
    this.description = description;
  }

  public static OrigemType toType(Integer id) {
    return EnumUtil.toType(id, OrigemType.class);
  }
}