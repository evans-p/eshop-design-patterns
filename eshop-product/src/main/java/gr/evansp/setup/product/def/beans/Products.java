package gr.evansp.setup.product.def.beans;

import gr.evansp.setup.product.def.models.Product;

import java.util.Set;

/**
 * A set of {@link Product}s.
 */
@SuppressWarnings("unused")
public interface Products {
  /**
   * Getter for products.
   *
   * @return products.
   */
  Set<Product> getProducts();

  /**
   * Setter for products.
   *
   * @param products products to set.
   */
  void setProducts(Set<Product> products);


}
