package gr.evansp.setup.product.def.beans;

import gr.evansp.setup.product.def.models.Product;

/**
 * {@link Product} SKU.
 */
public interface SKU {
  /**
   * Getter for product SKU.
   *
   * @return SKU
   */
  String getSKU();

  /**
   * Setter for product SKU.
   *
   * @param sku SKU to set.
   */
  void setSKU(String sku);
}
