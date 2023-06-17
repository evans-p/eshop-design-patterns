package gr.evansp.setup.product.def.beans;

import gr.evansp.setup.product.def.models.Product;

/**
 * {@link Product} inventory limit.
 */
public interface InventoryLimit {
  /**
   * Getter for inventory limit.
   *
   * @return inventory limit
   */
  Integer getInventoryLimit();

  /**
   * Setter for inventory limit.
   *
   * @param inventoryLimit inventory limit to set.
   */
  void setInventoryLimit(Integer inventoryLimit);
}
