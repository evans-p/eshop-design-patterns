package gr.evansp.setup.order.def.enums;

import gr.evansp.setup.order.def.models.Order;

/**
 * Enum, representing the status of an {@link Order}.
 */
@SuppressWarnings("unused")
public enum OrderStatus {
    PENDING,
    SHIPPED,
    DELIVERED,
    CANCELLED
}
