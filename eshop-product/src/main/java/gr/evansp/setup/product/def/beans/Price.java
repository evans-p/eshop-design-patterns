package gr.evansp.setup.product.def.beans;

import gr.evansp.setup.product.def.models.Product;

import java.math.BigDecimal;

/**
 * {@link Product} Price.
 */
public interface Price {
  /**
   * Getter for product price.
   *
   * @return product price
   */
  public BigDecimal getPrice();

  /**
   * Setter for product price.
   *
   * @param price price to set.
   */
  public void setPrice(BigDecimal price);
}
