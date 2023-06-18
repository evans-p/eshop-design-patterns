package gr.evansp.setup.order.def.beans;

import gr.evansp.setup.order.def.enums.OrderStatus;
import gr.evansp.setup.order.def.models.Order;

/**
 * Status of the {@link Order}
 */
public interface Status {
    /**
     * Getter for order status.
     *
     * @return {@link OrderStatus}.
     */
    OrderStatus getStatus();

    /**
     * Setter for order status.
     *
     * @param status {@link OrderStatus} to set.
     */
    void setStatus(OrderStatus status);
}
