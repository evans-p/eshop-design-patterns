package gr.evansp.setup.order.def.operations;

import gr.evansp.common.Operation;
import gr.evansp.setup.order.def.models.CartItem;


/**
 * Saves or updates a {@link CartItem} to the DB.
 */
@SuppressWarnings("unused")
public interface SaveCartItemOperation extends Operation {
  /**
   * Getter for the input.
   *
   * @return input(CartItem).
   */
  CartItem getInput();

  /**
   * Setter for the input.
   *
   * @param input CartItem to set.
   */
  void setInput(CartItem input);
}
