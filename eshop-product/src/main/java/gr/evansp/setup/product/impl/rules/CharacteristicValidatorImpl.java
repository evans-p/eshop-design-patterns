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
    builder.append(validateName());
    builder.append(validateValue());
    builder.append(validateProduct());

    if (builder.toString().length() > 0) {
      throw new RuleException(builder.toString());
    }
  }

  private String validateProduct() {
    if (input.getProduct() == null)
      return "Characteristic product cannot be null";
    return "";
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
