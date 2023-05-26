package gr.evansp.setup.product.def.operations;

import gr.evansp.common.Operation;
import gr.evansp.setup.product.def.models.Product;

/**
 * Saves a new {@link Product} to the DB, or
 * updates an existing one.
 */
public interface SaveProductOperation extends Operation {
  /**
   * Getter for the input.
   *
   * @return input(Product).
   */
  public Product getInput();

  /**
   * Setter for the input.
   *
   * @param input Product to set.
   */
  public void setInput(Product input);
}
