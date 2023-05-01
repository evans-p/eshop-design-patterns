package gr.evansp.setup.product.def.beans;

import gr.evansp.setup.product.def.models.Product;

import java.util.Set;

/**
 * A set of {@link Product}s.
 */
public interface Products {
  /**
   * Getter for products.
   *
   * @return products.
   */
  public Set<Product> getProducts();

  /**
   * Setter for products.
   *
   * @param products products to set.
   */
  public void setProducts(Set<Product> products);


}
