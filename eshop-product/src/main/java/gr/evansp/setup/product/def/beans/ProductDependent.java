package gr.evansp.setup.product.def.beans;

import gr.evansp.setup.product.def.models.Product;

/**
 * Something that depends on {@link Product}
 */
@SuppressWarnings("unused")
public interface ProductDependent {
  /**
   * Getter for product.
   *
   * @return product
   */
  Product getProduct();

  /**
   * Setter for Product.
   *
   * @param product product to set.
   */
  void setProduct(Product product);
}
