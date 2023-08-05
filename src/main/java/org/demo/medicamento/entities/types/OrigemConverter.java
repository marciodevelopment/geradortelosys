package org.demo.medicamento.entities.types;

import jakarta.persistence.AttributeConverter;


public class OrigemConverter implements AttributeConverter<OrigemType, Integer> {

  @Override
  public Integer convertToDatabaseColumn(OrigemType type) {
    if (type == null)
      return null;
    return type.getId();
  }

  @Override
  public OrigemType convertToEntityAttribute(Integer id) {
    return OrigemType.toType(id);
  }
}
