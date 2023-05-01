package gr.evansp.setup.product.def.beans;

import gr.evansp.setup.product.def.models.Product;

/**
 * Something that depends on {@link Product}
 */
public interface ProductDependent {
  /**
   * Getter for product.
   *
   * @return product
   */
  public Product getProduct();

  /**
   * Setter for Product.
   *
   * @param product product to set.
   */
  public void setProduct(Product product);
}
