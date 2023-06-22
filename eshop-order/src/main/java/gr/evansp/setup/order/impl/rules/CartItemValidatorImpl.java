package gr.evansp.setup.order.impl.rules;

import gr.evansp.constants.StringConstants;
import gr.evansp.exceptions.RuleException;
import gr.evansp.setup.order.def.models.CartItem;
import gr.evansp.setup.order.def.rules.CartItemValidator;
import lombok.Getter;
import lombok.Setter;

/**
 * Implementation of {@link CartItemValidator}
 */
public class CartItemValidatorImpl implements CartItemValidator {
  @Setter
  @Getter
  CartItem input;

  @Override
  public void apply() throws RuleException {
    StringBuilder builder = new StringBuilder();
    builder.append(validateCartId());
    builder.append(validateCategoryId());
    builder.append(validateProductId());
    builder.append(validateCount());

    if (builder.length() > 0) {
      throw new RuleException(builder.toString());
    }
  }

  private String validateCategoryId() {
    if (input.getCategoryId() == null) {
      return "Category Id cannot be null";
    }
    return StringConstants.EMPTY;
  }

  private String validateCartId() {
    if (input.getCartId() == null) {
      return "Cart Id cannot be null";
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
