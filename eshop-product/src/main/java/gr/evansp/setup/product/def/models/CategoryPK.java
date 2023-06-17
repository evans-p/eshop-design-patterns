package gr.evansp.setup.product.def.models;

/**
 * Primary key for {@link Product} {@link Category}.
 */
public interface CategoryPK {
  /**
   * Getter for category Id.
   *
   * @return Id.
   */
  Long getCategoryId();

  /**
   * Setter for category Id.
   *
   * @param categoryId Id to set
   */
  void setCategoryId(Long categoryId);
}
