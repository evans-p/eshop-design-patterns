package gr.evansp.setup.order.def.beans;

import gr.evansp.setup.order.def.models.Cart;

/**
 * Something that has a cart.
 */
public interface CartDependent {
    /**
     * Getter for cart.
     *
     * @return cart.
     */
    Cart getCart();

    /**
     * Setter for cart.
     *
     * @param cart cart to set.
     */
    void setCart(Cart cart);
}
