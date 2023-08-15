package br.org.curitiba.ici.saude.usuario.entities.types;

import br.org.curitiba.ici.saude.common.EnumUtil;
import lombok.Getter;



@Getter
public enum SexoType {
  MASCULINO(1, "Masculino"), FEMININO(2, "Feminino");

  private final int id;
  private final String description;

  private SexoType(int id, String description) {
    this.id = id;
    this.description = description;
  }

  public static SexoType toType(Integer id) {
    return EnumUtil.toType(id, SexoType.class);
  }
}
