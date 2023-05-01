package gr.evansp.setup.product.def.beans;

import gr.evansp.setup.product.def.models.Category;

/**
 * Something that dependeds on {@link Category}
 */
public interface CategoryDependent {
  /**
   * Getter for category.
   *
   * @return category.
   */
  public Category getCategory();

  /**
   * Setter for category.
   *
   * @param category category to set.
   */
  public void setCategory(Category category);

}
