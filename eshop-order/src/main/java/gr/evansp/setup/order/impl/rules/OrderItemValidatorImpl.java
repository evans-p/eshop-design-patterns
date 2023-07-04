package gr.evansp.setup.order.impl.rules;


import gr.evansp.constants.StringConstants;
import gr.evansp.exceptions.RuleException;
import gr.evansp.setup.order.def.models.OrderItem;
import gr.evansp.setup.order.def.rules.OrderItemValidator;
import lombok.Getter;
import lombok.Setter;

/**
 * Implementation of {@link OrderItemValidator}
 */
public class OrderItemValidatorImpl implements OrderItemValidator {
    @Setter
    @Getter
    OrderItem input;

    @Override
    public void apply() throws RuleException {
        StringBuilder builder = new StringBuilder();

        builder.append(validateCategoryId());
        builder.append(validateProductId());
        builder.append(validateCount());
        builder.append(validateOrderId());
        builder.append(validateUserId());

        if (builder.length() > 0) {
            throw new RuleException(builder.toString());
        }
    }


    private String validateOrderId() {
        if (input.getOrderId() == null) {
            return "Order Id cannot be null";
        }
        return StringConstants.EMPTY;
    }

    private String validateUserId() {
        if (input.getUserId() == null) {
            return "User Id cannot be null";
        }
        return StringConstants.EMPTY;
    }

    private String validateCategoryId() {
        if (input.getCategoryId() == null) {
            return "Category Id cannot be null";
        }
        return StringConstants.EMPTY;
    }

    private String validateProductId() {
        if (input.getProductId() == null) {
            return "Product Id cannot be null";
        }
        return StringConstants.EMPTY;
    }

    private String validateCount() {
        if (input.getCount() == null) {
            return "Count cannot be null";
        }

        if (input.getCount() <= 0) {
            return "Count must be greater than zero.";
        }
        return StringConstants.EMPTY;
    }
}
