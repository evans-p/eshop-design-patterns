package gr.evansp.setup.product.def.operations;

import gr.evansp.common.Operation;
import gr.evansp.setup.product.def.models.Category;

/**
 * Saves a new {@link Category} category to the DB, or
 * updates an existing one.
 */
public interface SaveCategoryOperation extends Operation {
  /**
   * Getter for the input.
   *
   * @return input(Category).
   */
  Category getInput();

  /**
   * Setter for the input.
   *
   * @param input Category to set.
   */
  void setInput(Category input);
}
