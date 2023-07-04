package gr.evansp.setup.order.def.beans;

import gr.evansp.setup.order.def.models.OrderItem;

import java.util.Set;

/**
 * A set of {@link OrderItem}.
 */
public interface OrderItems {
    /**
     * Getter for Order Items
     *
     * @return order items.
     */
    Set<OrderItem> getOrderItems();

    /**
     * Setter for order items.
     *
     * @param orderItems orderItems to set.
     */
    void setOrderItems(Set<OrderItem> orderItems);
}
