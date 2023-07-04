package gr.evansp.setup.order.def.operations;

import gr.evansp.common.Input;
import gr.evansp.common.Operation;
import gr.evansp.setup.order.def.models.CartItem;


/**
 * Saves or updates a {@link CartItem} to the DB.
 */
public interface SaveCartItemOperation extends Operation, Input<CartItem> {
    //EMPTY
}
