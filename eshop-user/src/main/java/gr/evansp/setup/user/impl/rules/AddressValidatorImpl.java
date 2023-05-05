package gr.evansp.setup.user.impl.rules;

import gr.evansp.exceptions.RuleException;
import gr.evansp.setup.user.def.models.Address;
import gr.evansp.setup.user.def.rules.AddressValidator;

import static gr.evansp.rules.RuleUtils.checkContainsOnlyLetters;
import static gr.evansp.rules.RuleUtils.checkContainsOnlyNumbers;

/**
 * Implementation of {@link AddressValidator}
 */
public class AddressValidatorImpl implements AddressValidator {
  private Address input;

  @Override
  public Address getInput() {
    return input;
  }

  @Override
  public void setInput(Address address) {
    this.input = address;
  }
  
  @Override
  public void apply() throws RuleException {
    StringBuilder builder = new StringBuilder();

    builder.append(validateAddressId());
    builder.append(validateCity());
    builder.append(validateCountry());
    builder.append(validatePostalCode());
    builder.append(validateUserProfile());
    builder.append(validateStreetName());
    builder.append(validateStreetNameNumber());

    if (builder.toString().length() > 0) {
      throw new RuleException(builder.toString());
    }
  }

  private String validateAddressId() {
    String result = "";
    if (input.getAddressId() == null)
      return "Address Id cannot be null.\n";
    return result;
  }

  private String validateStreetName() {
    String result = "";
    if (input.getStreetName() == null)
      return "Street name cannot be null.";
    if (!checkContainsOnlyLetters(input.getStreetName()))
      result += "Street name must contain only letters.";
    return result;
  }

  private String validateStreetNameNumber() {
    String result = "";
    if (input.getStreetNumber() == null)
      return "Street number cannot be null.";
    if (!checkContainsOnlyNumbers(input.getStreetNumber()))
      result += "Street number must contain only numbers.";
    return result;
  }

  private String validatePostalCode() {
    String result = "";
    if (input.getPostalCode() == null)
      return "Postal code cannot be null.";
    if (!checkContainsOnlyNumbers(input.getPostalCode()))
      result += "Postal Code must contain only numbers.";
    return result;
  }

  private String validateCity() {
    String result = "";
    if (input.getCity() == null)
      return "City cannot be null.";
    if (!checkContainsOnlyLetters(input.getCity()))
      result += "City must contain only letters.";
    return result;
  }

  private String validateCountry() {
    String result = "";
    if (input.getCountry() == null)
      return "Country cannot be null.";
    if (!checkContainsOnlyLetters(input.getCountry()))
      result += "Country must contain only letters.";
    return result;
  }

  private String validateUserProfile() {
    String result = "";
    if (input.getUserProfile() == null)
      return "UserProfile cannot be null.";
    return result;
  }
}