package gr.evansp.setup.order.def.models;

import gr.evansp.setup.user.def.models.UserPK;

/**
 * {@link Cart} primary key.
 */
public interface CartPK extends UserPK {
    /**
     * Getter for Cart Id.
     *
     * @return cart Id.
     */
    Long getCartId();


    /**
     * Setter for cart id.
     *
     * @param cartId cartId to set.
     */
    void setCartId(Long cartId);
}
