package gr.evansp.setup.product.impl.models;

import gr.evansp.setup.product.def.models.Characteristic;
import gr.evansp.setup.product.def.models.Product;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Implementation of {@link Product}.
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ProductImpl implements Product {

  @EqualsAndHashCode.Include
  private Long productId;

  @EqualsAndHashCode.Include
  private Long categoryId;

  private String SKU;
  private String name;
  private Integer inventoryCount;
  private Integer inventoryLimit;
  private BigDecimal price;
  private String description;
  private Date dateAdded;
  private Date dateLastModified;
  private Set<Characteristic> characteristics = new HashSet<>();
}
