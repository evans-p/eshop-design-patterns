package gr.evansp.setup.order.def.models;

import gr.evansp.beans.Count;
import gr.evansp.common.Entity;
import gr.evansp.setup.product.def.models.Product;

/**
 * Cart Item. Represents the many-to-many relationship between
 * {@link Cart} and {@link Product}.
 */
public interface CartItem extends CartItemPK, Count, Entity {
    // EMPTY
}
