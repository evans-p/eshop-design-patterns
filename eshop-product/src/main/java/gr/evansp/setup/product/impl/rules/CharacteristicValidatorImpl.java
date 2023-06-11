package gr.evansp.setup.product.impl.rules;

import gr.evansp.constants.StringConstants;
import gr.evansp.exceptions.RuleException;
import gr.evansp.setup.product.def.models.Characteristic;
import gr.evansp.setup.product.def.rules.CharacteristicValidator;
import lombok.Getter;
import lombok.Setter;

/**
 * Implementation of {@link CharacteristicValidator}
 */
public class CharacteristicValidatorImpl implements CharacteristicValidator {
  @Setter
  @Getter
  private Characteristic input;


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
    return StringConstants.EMPTY;
  }

  private String validateCategoryId() {
    String result = StringConstants.EMPTY;
    if (input.getCategoryId() == null)
      return "Category Id cannot be null.\n";
    return result;
  }

  private String validateCharacteristicId() {
    if (input.getCharacteristicId() == null)
      return "Characteristic Id cannot be null";
    return StringConstants.EMPTY;
  }

  private String validateName() {
    if (input.getName() == null) {
      return "Characteristic name cannot be null.";
    }
    if (input.getName().length() == 0) {
      return "Characteristic name cannot be empty.";
    }
    return StringConstants.EMPTY;
  }

  private String validateValue() {
    if (input.getValue() == null) {
      return "Characteristic value cannot be null.";
    }
    if (input.getValue().length() == 0) {
      return "Characteristic value cannot be empty.";
    }
    return StringConstants.EMPTY;
  }
}
