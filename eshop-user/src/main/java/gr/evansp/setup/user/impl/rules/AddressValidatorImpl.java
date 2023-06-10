package gr.evansp.setup.user.impl.rules;

import gr.evansp.constants.StringConstants;
import gr.evansp.exceptions.RuleException;
import gr.evansp.setup.user.def.models.Address;
import gr.evansp.setup.user.def.rules.AddressValidator;
import lombok.Getter;
import lombok.Setter;

import static gr.evansp.rules.RuleUtils.checkContainsOnlyLetters;
import static gr.evansp.rules.RuleUtils.checkContainsOnlyNumbers;

/**
 * Implementation of {@link AddressValidator}.
 */
public class AddressValidatorImpl implements AddressValidator {
  @Getter
  @Setter
  private Address input;

  @Override
  public void apply() throws RuleException {
    StringBuilder builder = new StringBuilder();

    builder.append(validateAddressId());
    builder.append(validateCity());
    builder.append(validateCountry());
    builder.append(validatePostalCode());
    builder.append(validateStreetName());
    builder.append(validateStreetNameNumber());
    builder.append(validateUserId());

    if (builder.toString().length() > 0) {
      throw new RuleException(builder.toString());
    }
  }

  private String validateUserId() {
    String result = StringConstants.EMPTY;
    if (input.getUserId() == null) {
      return "User Id cannot be null.\n";
    }
    return result;
  }

  private String validateAddressId() {
    String result = StringConstants.EMPTY;
    if (input.getAddressId() == null) {
      return "Address Id cannot be null.\n";
    }
    return result;
  }

  private String validateStreetName() {
    String result = StringConstants.EMPTY;
    if (input.getStreetName() == null) {
      return "Street name cannot be null.";
    }
    if (input.getStreetName().equals(StringConstants.EMPTY)) {
      return "Street name cannot be empty.";
    }
    if (!checkContainsOnlyLetters(input.getStreetName())) {
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
    if (!checkContainsOnlyNumbers(input.getStreetNumber())) {
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
    if (!checkContainsOnlyNumbers(input.getPostalCode())) {
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
    if (!checkContainsOnlyLetters(input.getCity())) {
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
    if (!checkContainsOnlyLetters(input.getCountry())) {
      result += "Country must contain only letters.";
    }
    return result;
  }
}
