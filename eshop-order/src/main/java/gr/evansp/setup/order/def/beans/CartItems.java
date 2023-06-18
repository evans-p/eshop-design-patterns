package gr.evansp.setup.order.def.beans;

import gr.evansp.setup.order.def.models.CartItem;

import java.util.Set;

/**
 * A set of {@link CartItem}.
 */
public interface CartItems {
    /**
     * Getter for Cart Items
     *
     * @return cart items.
     */
    Set<CartItem> getCartItems();

    /**
     * Setter for cart items.
     *
     * @param cartItems cartItems to set.
     */
    void setCartItems(Set<CartItem> cartItems);
}
