package gr.evansp.setup.product.impl.models;

import gr.evansp.constants.StringConstants;
import gr.evansp.setup.product.def.models.Characteristic;
import gr.evansp.setup.product.def.models.Product;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Calendar;
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

  private String SKU = StringConstants.EMPTY;
  private String name = StringConstants.EMPTY;
  private Integer inventoryCount;
  private Integer inventoryLimit;
  private BigDecimal price = BigDecimal.ZERO;
  private String description = StringConstants.EMPTY;
  private Date dateAdded = Calendar.getInstance().getTime();
  private Date dateLastModified = Calendar.getInstance().getTime();
  private Set<Characteristic> characteristics = new HashSet<>();
}
