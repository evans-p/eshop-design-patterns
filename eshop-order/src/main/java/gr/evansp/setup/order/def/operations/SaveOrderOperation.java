package gr.evansp.setup.order.def.operations;

import gr.evansp.common.Input;
import gr.evansp.common.Operation;
import gr.evansp.setup.order.def.models.Order;

/**
 * Saves or updates {@link Order}.
 */
public interface SaveOrderOperation extends Operation, Input<Order> {
}
