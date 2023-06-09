package gr.evansp.setup.product.def.operations;

import gr.evansp.common.Operation;
import gr.evansp.setup.product.def.models.Characteristic;

/**
 * Saves a new {@link Characteristic} category to the DB, or
 * updates an existing one.
 */
public interface SaveCharacteristicOperation extends Operation {
  /**
   * Getter for the input.
   *
   * @return input(Characteristic).
   */
  Characteristic getInput();

  /**
   * Setter for the input.
   *
   * @param input Characteristic to set.
   */
  void setInput(Characteristic input);
}

