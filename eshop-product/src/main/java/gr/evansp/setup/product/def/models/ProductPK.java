package gr.evansp.setup.product.def.models;

/**
 * Primary key for {@link Product}
 */
public interface ProductPK extends CategoryPK {
  /**
   * Getter for product Id.
   *
   * @return Id.
   */
  Long getProductId();

  /**
   * Setter for product Id.
   *
   * @param productId id to set.
   */
  void setProductId(Long productId);
}
