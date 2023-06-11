package gr.evansp.setup.user.impl.rules;

import gr.evansp.constants.StringConstants;
import gr.evansp.exceptions.DataException;
import gr.evansp.exceptions.LogicException;
import gr.evansp.exceptions.RuleException;
import gr.evansp.factory.Factory;
import gr.evansp.setup.user.def.models.Address;
import gr.evansp.setup.user.def.models.UserProfile;
import gr.evansp.setup.user.def.rules.AddressValidator;
import gr.evansp.setup.user.def.rules.UserProfileValidator;
import lombok.Getter;
import lombok.Setter;

import static gr.evansp.rules.RuleUtils.checkContainsOnlyNumbers;


/**
 * Implementation for {@link UserProfileValidator}.
 */
public class UserProfileValidatorImpl implements UserProfileValidator {
  AddressValidator addressValidator = Factory.create(AddressValidator.class);
  @Getter
  @Setter
  private UserProfile input;

  @Override
  public void apply() throws RuleException, DataException, LogicException {
    StringBuilder builder = new StringBuilder();

    builder.append(validateUserId());
    builder.append(validateDateAdded());
    builder.append(validateDateLastModified());
    builder.append(validateFirstName());
    builder.append(validateLastName());
    builder.append(validatePhoneNo());

    if (builder.toString().length() > 0) {
      throw new RuleException(builder.toString());
    }

    if ((input.getAddresses() != null) && (!input.getAddresses().isEmpty())) {
      for (Address address : input.getAddresses()) {
        addressValidator.setInput(address);
        addressValidator.apply();
      }
    }
  }


  private String validateUserId() {
    String result = "";
    if (input.getUserId() == null) {
      result = "User Id cannot be null";
    }
    return result;
  }

  private String validateFirstName() {
    if (input.getFirstName() == null) {
      return "First Name cannot be null.";
    }
    if (input.getFirstName().length() == 0) {
      return "First Name cannot be empty.";
    }
    return StringConstants.EMPTY;
  }

  private String validateLastName() {
    if (input.getLastName() == null) {
      return "Last Name cannot be null.";
    }

    if (input.getLastName().length() == 0) {
      return "Last Name cannot be empty.";
    }

    return StringConstants.EMPTY;
  }

  private String validatePhoneNo() {
    String result = StringConstants.EMPTY;
    if (input.getPhoneNo() == null) {
      return "Phone number cannot be null";
    }
    if (input.getPhoneNo().equals(StringConstants.EMPTY)) {
      return "Phone number cannot be empty";
    }
    if (!checkContainsOnlyNumbers(input.getPhoneNo())) {
      result += "Phone number cannot contain letters.";
    }
    if (input.getPhoneNo().length() != 10) {
      result += "Phone number must have exactly 10 digits";
    }
    return result;
  }

  private String validateDateAdded() {
    if (input.getDateAdded() == null) {
      return "Date added cannot be null.";
    }
    return StringConstants.EMPTY;
  }

  private String validateDateLastModified() {
    if (input.getDateLastModified() == null) {
      return StringConstants.EMPTY;
    }
    if (input.getDateAdded() == null) {
      return StringConstants.EMPTY;
    }
    if (input.getDateAdded().compareTo(input.getDateLastModified()) > 0) {
      return "Date last modified must be the same or greater than date added.";
    }
    return StringConstants.EMPTY;
  }
}
