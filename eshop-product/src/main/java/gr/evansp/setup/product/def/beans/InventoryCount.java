package gr.evansp.setup.product.def.beans;

import gr.evansp.setup.product.def.models.Product;

/**
 * {@link Product} inventory count.
 */
public interface InventoryCount {
  /**
   * Getter for inventory count.
   *
   * @return inventory count
   */
  Integer getInventoryCount();

  /**
   * Setter for inventory count.
   *
   * @param count inventory count to set.
   */
  void setInventoryCount(Integer count);
}
