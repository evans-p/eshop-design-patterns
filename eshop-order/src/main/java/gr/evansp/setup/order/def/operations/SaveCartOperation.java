package gr.evansp.setup.order.def.operations;

import gr.evansp.common.Operation;
import gr.evansp.setup.order.def.models.Cart;

/**
 * Saves or updates a {@link Cart} to the DB.
 */
public interface SaveCartOperation extends Operation {
    /**
     * Getter for the input.
     *
     * @return input(Cart).
     */
    Cart getInput();

    /**
     * Setter for the input.
     *
     * @param input Cart to set.
     */
    void setInput(Cart input);
}
