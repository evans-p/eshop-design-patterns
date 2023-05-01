package gr.evansp.setup.product.def.models;

/**
 * Primary key for {@link Product}
 */
public interface ProductPK {
  /**
   * Getter for product Id.
   *
   * @return Id.
   */
  public Long getProductId();

  /**
   * Setter for product Id.
   *
   * @param productId id to set.
   */
  public void setProductId(Long productId);
}
