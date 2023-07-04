package gr.evansp.setup.order.impl.rules;

import gr.evansp.constants.StringConstants;
import gr.evansp.exceptions.DataException;
import gr.evansp.exceptions.LogicException;
import gr.evansp.exceptions.RuleException;
import gr.evansp.factory.Factory;
import gr.evansp.setup.order.def.models.Cart;
import gr.evansp.setup.order.def.models.CartItem;
import gr.evansp.setup.order.def.rules.CartItemValidator;
import gr.evansp.setup.order.def.rules.CartValidator;
import lombok.Getter;
import lombok.Setter;


/**
 * Implementation of {@link CartValidator}.
 */
public class CartValidatorImpl implements CartValidator {
    CartItemValidator validator = Factory.create(CartItemValidator.class);
    @Setter
    @Getter
    Cart input;

    @Override
    public void apply() throws RuleException, DataException, LogicException {
        StringBuilder builder = new StringBuilder();

        builder.append(validateCartId());

        if (builder.length() > 0) {
            throw new RuleException(builder.toString());
        }

        for (CartItem c : input.getCartItems()) {
            validator.setInput(c);
            validator.apply();
        }
    }

    private String validateCartId() {
        if (input.getCartId() == null) {
            return "Cart Id cannot be null.";
        }
        return StringConstants.EMPTY;
    }
}
