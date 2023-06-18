package gr.evansp.setup.order.def.rules;

import gr.evansp.common.Rule;
import gr.evansp.setup.order.def.models.Cart;
import gr.evansp.setup.order.def.models.CartItem;

/**
 * Validator for {@link  Cart}. In Order for a cart to be
 * validated, it must follow the rules below:
 * <ul>
 *     <li>Cart id must not be null.</li>
 *     <li>Each {@link CartItem} must be validated with the appropriate validator.</li>
 * </ul>
 */
public interface CartValidator extends Rule<Cart> {
    //EMPTY
}
