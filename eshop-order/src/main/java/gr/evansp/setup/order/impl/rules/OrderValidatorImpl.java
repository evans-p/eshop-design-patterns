package gr.evansp.setup.order.impl.rules;

import gr.evansp.constants.StringConstants;
import gr.evansp.exceptions.DataException;
import gr.evansp.exceptions.LogicException;
import gr.evansp.exceptions.RuleException;
import gr.evansp.factory.Factory;
import gr.evansp.setup.order.def.models.Order;
import gr.evansp.setup.order.def.models.OrderItem;
import gr.evansp.setup.order.def.rules.OrderItemValidator;
import gr.evansp.setup.order.def.rules.OrderValidator;
import lombok.Getter;
import lombok.Setter;

import static gr.evansp.rules.RuleUtils.checkContainsOnlyLetters;
import static gr.evansp.rules.RuleUtils.checkContainsOnlyNumbers;

/**
 * Implementation of {@link OrderValidator}.
 */
public class OrderValidatorImpl implements OrderValidator {
    @Setter
    @Getter
    Order input;
    OrderItemValidator validator = Factory.create(OrderItemValidator.class);

    public void apply() throws RuleException, DataException, LogicException {
        StringBuilder builder = new StringBuilder();

        builder.append(validateCity());
        builder.append(validateCountry());
        builder.append(validatePostalCode());
        builder.append(validateStreetName());
        builder.append(validateStreetNameNumber());
        builder.append(validateOrderItems());

        if (builder.toString().length() > 0) {
            throw new RuleException(builder.toString());
        }

        for (OrderItem orderItem : input.getOrderItems()) {
            validator.setInput(orderItem);
            validator.apply();
        }
    }

    public String validateOrderItems() {
        if (input.getOrderItems() == null) {
            return "Order items cannot be null";
        }
        if (input.getOrderItems().isEmpty()) {
            return "Order items cannot be empty";
        }
        return StringConstants.EMPTY;
    }

    private String validateStreetName() {
        String result = StringConstants.EMPTY;
        if (input.getStreetName() == null) {
            return "Street name cannot be null.";
        }
        if (input.getStreetName().equals(StringConstants.EMPTY)) {
            return "Street name cannot be empty.";
        }
        if (checkContainsOnlyLetters(input.getStreetName())) {
            result += "Street name must contain only letters.";
        }
        return result;
    }

    private String validateStreetNameNumber() {
        String result = StringConstants.EMPTY;
        if (input.getStreetNumber() == null) {
            return "Street number cannot be null.";
        }
        if (input.getStreetNumber().equals(StringConstants.EMPTY)) {
            return "Street number cannot be empty.";
        }
        if (checkContainsOnlyNumbers(input.getStreetNumber())) {
            result += "Street number must contain only numbers.";
        }
        return result;
    }

    private String validatePostalCode() {
        String result = StringConstants.EMPTY;
        if (input.getPostalCode() == null) {
            return "Postal code cannot be null.";
        }
        if (input.getPostalCode().equals(StringConstants.EMPTY)) {
            return "Postal code cannot be empty.";
        }
        if (checkContainsOnlyNumbers(input.getPostalCode())) {
            result += "Postal Code must contain only numbers.";
        }
        return result;
    }

    private String validateCity() {
        String result = StringConstants.EMPTY;
        if (input.getCity() == null) {
            return "City cannot be null.";
        }
        if (input.getCity().equals(StringConstants.EMPTY)) {
            return "City cannot be empty.";
        }
        if (checkContainsOnlyLetters(input.getCity())) {
            result += "City must contain only letters.";
        }
        return result;
    }

    private String validateCountry() {
        String result = StringConstants.EMPTY;
        if (input.getCountry() == null) {
            return "Country cannot be null.";
        }
        if (input.getCountry().equals(StringConstants.EMPTY)) {
            return "Country cannot be empty.";
        }
        if (checkContainsOnlyLetters(input.getCountry())) {
            result += "Country must contain only letters.";
        }
        return result;
    }

}
