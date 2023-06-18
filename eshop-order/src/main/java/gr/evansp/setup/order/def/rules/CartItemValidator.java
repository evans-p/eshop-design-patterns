package gr.evansp.setup.order.def.rules;

import gr.evansp.common.Rule;
import gr.evansp.setup.order.def.models.CartItem;

/**
 * Validator for {@link CartItem}. In order for cart item to be valid,
 * it must follow the rules below:
 * <ul>
 *     <li>categoryId must not be null.</li>
 *     <li>product must not be null.</li>
 *     <li>cart Id must not be null.</li>
 *     <li>count must not be null.</li>
 *     <li>count must be greater than zero.</li>
 * </ul>
 */
public interface CartItemValidator extends Rule<CartItem> {
    //EMPTY
}
