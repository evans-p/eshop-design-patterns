package gr.evansp.setup.order.def.rules;

import gr.evansp.common.Rule;
import gr.evansp.setup.order.def.models.Order;

/**
 * Validator for {@link  Order}. In Order for an Order to be
 * validated, it must follow the rules below:
 * <ul>
 * <li>Order id must not be null.</li>
 * <li>userId id must not be null.</li>
 * <li>dateAdded must not be null</li>
 * <li>dateLastModified must be greater than or equal to dateAdded, if it is not null</li>
 * <li>order status cannot be null.</li>
 * <li>streetName must not be null or empty</li>
 * <li>streetName must contain only letters</li>
 * <li>streetNumber must not be null or empty</li>
 * <li>streetNumber must only contain numbers</li>
 * <li>postalCode must not be null or empty</li>
 * <li>postalCode must only contain numbers</li>
 * <li>city must not be null or empty</li>
 * <li>city must contain only letters</li>
 * <li>Country must not be null or empty</li>
 * <li>Country must contain only letters</li>
 * <li>Cart Items cannot be null and must be validated by the appropriate validator</li>
 * </ul>
 */
public interface OrderValidator extends Rule<Order> {
    //EMPTY
}
