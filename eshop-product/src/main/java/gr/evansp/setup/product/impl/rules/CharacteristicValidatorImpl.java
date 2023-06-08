package gr.evansp.setup.product.impl.rules;

import gr.evansp.exceptions.RuleException;
import gr.evansp.setup.product.def.models.Characteristic;
import gr.evansp.setup.product.def.rules.CharacteristicValidator;

/**
 * Implementation of {@link CharacteristicValidator}
 */
public class CharacteristicValidatorImpl implements CharacteristicValidator {
  private Characteristic input;

  @Override
  public Characteristic getInput() {
    return input;
  }

  @Override
  public void setInput(Characteristic input) {
    this.input = input;
  }

  @Override
  public void apply() throws RuleException {
    StringBuilder builder = new StringBuilder();

    builder.append(validateCharacteristicId());
    builder.append(validateProductId());
    builder.append(validateCategoryId());
    builder.append(validateName());
    builder.append(validateValue());

    if (builder.toString().length() > 0) {
      throw new RuleException(builder.toString());
    }
  }

  private String validateProductId() {
    if (input.getProductId() == null) {
      return "Product Id must not be null";
    }
    return "";
  }

  private String validateCategoryId() {
    String result = "";
    if (input.getCategoryId() == null)
      return "Category Id cannot be null.\n";
    return result;
  }

  private String validateCharacteristicId() {
    if (input.getCharacteristicId() == null)
      return "Characteristic Id cannot be null";
    return "";
  }

  private String validateName() {
    if (input.getName() == null) {
      return "Characteristic name cannot be null.";
    }
    if (input.getName().length() == 0) {
      return "Characteristic name cannot be empty.";
    }
    return "";
  }

  private String validateValue() {
    if (input.getValue() == null) {
      return "Characteristic value cannot be null.";
    }
    if (input.getValue().length() == 0) {
      return "Characteristic value cannot be empty.";
    }
    return "";
  }
}
