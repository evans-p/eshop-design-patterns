package gr.evansp.setup.product.impl.rules;

import gr.evansp.constants.StringConstants;
import gr.evansp.exceptions.RuleException;
import gr.evansp.setup.product.def.models.Category;
import gr.evansp.setup.product.def.rules.CategoryValidator;
import lombok.Getter;
import lombok.Setter;

/**
 * implementation of {@link CategoryValidator}.
 */
public class CategoryValidatorImpl implements CategoryValidator {
  @Setter
  @Getter
  private Category input;

  @Override
  public void apply() throws RuleException {
    StringBuilder builder = new StringBuilder();

    builder.append(validateCategoryId());
    builder.append(validateName());

    if (builder.toString().length() > 0) {
      throw new RuleException(builder.toString());
    }
  }

  private String validateCategoryId() {
    String result = StringConstants.EMPTY;
    if (input.getCategoryId() == null) {
      return "Category Id cannot be null.\n";
    }
    return result;
  }

  private String validateName() {
    if (input.getName() == null) {
      return "Category name cannot be null.";
    }
    if (input.getName().length() == 0) {
      return "Category name cannot be empty.";
    }
    return StringConstants.EMPTY;
  }
}
