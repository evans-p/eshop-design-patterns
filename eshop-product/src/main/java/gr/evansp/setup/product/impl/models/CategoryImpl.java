package gr.evansp.setup.product.impl.models;

import gr.evansp.setup.product.def.models.Category;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Implementation of {@link Category}
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class CategoryImpl implements Category {

  @EqualsAndHashCode.Include
  private Long categoryId;

  private String name;
  private String description;
}
