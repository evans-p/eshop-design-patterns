package gr.evansp.setup.order.def.rules;

import gr.evansp.common.Rule;
import gr.evansp.setup.order.def.models.OrderItem;


/**
 * Validator for {@link OrderItem}. In order for order item to be valid,
 * it must follow the rules below:
 * <ul>
 *     <li>categoryId must not be null.</li>
 *     <li>product must not be null.</li>
 *     <li>user Id must not be null.</li>
 *     <li>order Id must not be null.</li>
 *     <li>count must not be null.</li>
 *     <li>count must be greater than zero.</li>
 * </ul>
 */
public interface OrderItemValidator extends Rule<OrderItem> {
}
