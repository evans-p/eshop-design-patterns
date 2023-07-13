package gr.evansp.setup.order.def.operations;

import gr.evansp.common.Input;
import gr.evansp.common.Operation;
import gr.evansp.setup.order.def.models.Cart;

/**
 * Saves or updates a {@link Cart} to the DB.
 */
public interface SaveCartOperation extends Operation, Input<Cart> {
  //EMPTY
}
