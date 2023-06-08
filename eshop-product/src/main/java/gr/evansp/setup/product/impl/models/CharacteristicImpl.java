package gr.evansp.setup.product.impl.models;

import gr.evansp.setup.product.def.models.Characteristic;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class CharacteristicImpl implements Characteristic {
  
  @EqualsAndHashCode.Include
  private Long characteristicId;

  @EqualsAndHashCode.Include
  private Long categoryId;

  @EqualsAndHashCode.Include
  private Long productId;

  private String name;
  private String value;
}
