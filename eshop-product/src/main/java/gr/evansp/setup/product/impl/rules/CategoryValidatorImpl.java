package gr.evansp.setup.product.impl.rules;

import gr.evansp.exceptions.RuleException;
import gr.evansp.setup.product.def.models.Category;
import gr.evansp.setup.product.def.rules.CategoryValidator;

/**
 * implementation of {@link CategoryValidator}.
 */
public class CategoryValidatorImpl implements CategoryValidator {
  private Category input;

  @Override
  public Category getInput() {
    return input;
  }

  @Override
  public void setInput(Category input) {
    this.input = input;
  }
  
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
    String result = "";
    if (input.getCategoryId() == null)
      return "Category Id cannot be null.\n";
    return result;
  }

  private String validateName() {
    if (input.getName() == null) {
      return "Category name cannot be null.";
    }
    if (input.getName().length() == 0) {
      return "Category name cannot be empty.";
    }
    return "";
  }
}
