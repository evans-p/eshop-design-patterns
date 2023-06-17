package gr.evansp.setup.product.def.beans;

import gr.evansp.setup.product.def.models.Category;

/**
 * Something that dependeds on {@link Category}
 */
@SuppressWarnings("unused")
public interface CategoryDependent {
  /**
   * Getter for category.
   *
   * @return category.
   */
  Category getCategory();

  /**
   * Setter for category.
   *
   * @param category category to set.
   */
  void setCategory(Category category);

}
