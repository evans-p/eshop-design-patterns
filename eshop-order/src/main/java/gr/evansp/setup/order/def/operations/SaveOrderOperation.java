package gr.evansp.setup.order.def.operations;

import gr.evansp.common.Operation;
import gr.evansp.setup.order.def.models.Order;

/**
 * Saves or updates {@link Order}.
 */
@SuppressWarnings("unused")
public interface SaveOrderOperation extends Operation {
  /**
   * Getter for the input.
   *
   * @return input(Order).
   */
  Order getInput();

  /**
   * Setter for the input.
   *
   * @param input Order to set.
   */
  void setInput(Order input);
}
