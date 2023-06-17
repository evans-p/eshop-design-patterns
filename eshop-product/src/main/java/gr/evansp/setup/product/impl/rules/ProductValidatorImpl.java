package gr.evansp.setup.product.impl.rules;

import gr.evansp.constants.StringConstants;
import gr.evansp.exceptions.DataException;
import gr.evansp.exceptions.LogicException;
import gr.evansp.exceptions.RuleException;
import gr.evansp.factory.Factory;
import gr.evansp.setup.product.def.models.Characteristic;
import gr.evansp.setup.product.def.models.Product;
import gr.evansp.setup.product.def.rules.CharacteristicValidator;
import gr.evansp.setup.product.def.rules.ProductValidator;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

public class ProductValidatorImpl implements ProductValidator {
  private final CharacteristicValidator characteristicValidator = Factory.create(CharacteristicValidator.class);
  @Setter
  @Getter
  private Product input;

  @Override
  public void apply() throws RuleException, DataException, LogicException {
    StringBuilder builder = new StringBuilder();

    builder.append(validateProductId());
    builder.append(validateCharacteristics());
    builder.append(validateName());
    builder.append(validateSKU());
    builder.append(validateInventoryCount());
    builder.append(validateInventoryLimit());
    builder.append(validatePrice());
    builder.append(validateDateAdded());
    builder.append(validateDateLastModified());
    builder.append(validateCategoryId());

    if (!builder.isEmpty()) {
      throw new RuleException(builder.toString());
    }

    for (Characteristic c : input.getCharacteristics()) {
      characteristicValidator.setInput(c);
      characteristicValidator.apply();
    }
  }

  private String validateCategoryId() {
    String result = StringConstants.EMPTY;
    if (input.getCategoryId() == null)
      return "Category Id cannot be null.\n";
    return result;
  }

  private String validateProductId() {
    if (input.getProductId() == null) {
      return "Product Id must not be null";
    }
    return StringConstants.EMPTY;
  }

  private String validateSKU() {
    if (input.getSKU() == null) {
      return "Product SKU must not be null";
    }
    if (input.getSKU().equals(StringConstants.EMPTY)) {
      return "Product SKU must not be empty";
    }
    return StringConstants.EMPTY;
  }

  private String validateName() {
    if (input.getName() == null) {
      return "Product name must not be null";
    }
    if (input.getName().length() == 0) {
      return "Product name must not be empty.";
    }
    return StringConstants.EMPTY;
  }

  private String validateInventoryLimit() {
    if (input.getInventoryLimit() == null) {
      return "Product inventory limit must not be null";
    }
    if (input.getInventoryLimit() < 0) {
      return "Product inventory limit cannot be negative";
    }
    return StringConstants.EMPTY;
  }

  private String validateInventoryCount() {

    if (input.getInventoryCount() == null) {
      return "Product inventory count must not be null";
    }
    if (input.getInventoryCount() < 0) {
      return "Product inventory count cannot be negative";
    }

    if (input.getInventoryLimit() == null)
      return "Product inventory limit must not be null";

    if (input.getInventoryCount() > input.getInventoryLimit()) {
      return "Product inventory count cannot greater than inventory limit.";
    }
    return StringConstants.EMPTY;
  }

  private String validatePrice() {
    if (input.getPrice() == null) {
      return "Product price must not be null";

    }
    if (input.getPrice().compareTo(BigDecimal.ZERO) == 0) {

      return "Product price cannot be zero.";
    }
    if (input.getPrice().compareTo(BigDecimal.ZERO) < 0) {

      return "Product price cannot be negative.";
    }
    return StringConstants.EMPTY;
  }

  private String validateDateAdded() {
    if (input.getDateAdded() == null)
      return "Date added cannot be null.";
    return StringConstants.EMPTY;
  }

  private String validateDateLastModified() {
    if (input.getDateLastModified() == null)
      return StringConstants.EMPTY;
    if (input.getDateAdded() == null)
      return StringConstants.EMPTY;
    if (input.getDateAdded().compareTo(input.getDateLastModified()) > 0) {
      return "Date last modified must be the same or greater than date added.";
    }
    return StringConstants.EMPTY;
  }

  private String validateCharacteristics() {
    if (input.getCharacteristics() == null) {
      return "Product characteristics cannot be null.";
    }
    return StringConstants.EMPTY;
  }
}
