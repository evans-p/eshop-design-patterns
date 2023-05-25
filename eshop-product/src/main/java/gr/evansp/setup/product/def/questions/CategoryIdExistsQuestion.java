package gr.evansp.setup.product.def.questions;

import gr.evansp.common.Question;
import gr.evansp.setup.product.def.models.Category;

public interface CategoryIdExistsQuestion extends Question<Boolean> {
  /**
   * Getter for input
   *
   * @return input
   */
  public Category getInput();

  /**
   * setter for input.
   *
   * @param input input
   */
  public void setInput(Category input);
}
