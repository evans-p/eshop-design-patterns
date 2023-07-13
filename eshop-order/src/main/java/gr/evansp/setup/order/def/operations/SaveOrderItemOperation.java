package gr.evansp.setup.order.def.operations;

import gr.evansp.common.Input;
import gr.evansp.common.Operation;
import gr.evansp.setup.order.def.models.OrderItem;

/**
 * Saves or updates {@link OrderItem}
 */
public interface SaveOrderItemOperation extends Operation, Input<OrderItem> {
  //EMPTY
}
