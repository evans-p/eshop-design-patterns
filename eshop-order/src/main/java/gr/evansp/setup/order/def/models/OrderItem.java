package gr.evansp.setup.order.def.models;

import gr.evansp.beans.Count;
import gr.evansp.common.Entity;
import gr.evansp.setup.product.def.models.Product;

/**
 * Represents the link table between {@link Order} and {@link Product}.
 */
public interface OrderItem extends OrderItemPK, Count, Entity {
    //EMPTY
}
