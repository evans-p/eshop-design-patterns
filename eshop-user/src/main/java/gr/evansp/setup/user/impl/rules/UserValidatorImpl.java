package gr.evansp.setup.user.impl.rules;

import gr.evansp.exceptions.RuleException;
import gr.evansp.factory.Factory;
import gr.evansp.setup.user.def.models.User;
import gr.evansp.setup.user.def.rules.UserProfileValidator;
import gr.evansp.setup.user.def.rules.UserValidator;

import static gr.evansp.rules.RuleUtils.*;


/**
 * implementation of {@link UserValidator}
 */
public class UserValidatorImpl implements UserValidator {
  private User input;

  private UserProfileValidator validator = Factory.create(UserProfileValidator.class);

  @Override
  public User getInput() {
    return input;
  }

  @Override
  public void setInput(User input) {
    this.input = input;
  }

  @Override
  public void apply() throws RuleException {
    StringBuilder builder = new StringBuilder();

    builder.append(validateUserId());
    builder.append(validateEmail());
    builder.append(validatePassword());
    builder.append(validateUserProfile());

    if (builder.toString().length() > 0)
      throw new RuleException(builder.toString());

    validator.setInput(input.getUserProfile());
    validator.apply();
  }

  private String validateUserProfile() {
    if (input.getUserProfile() == null) {
      return "UserProfile must not be null";
    }
    return "";
  }

  private String validateUserId() {
    if (input.getUserId() == null)
      return "UserId must not be null";
    return "";
  }

  private String validateEmail() {
    if (input.getEmail() == null)
      return "Email must not be null.";
    if (input.getEmail() == "")
      return "Email must not be empty.";
    if (!input.getEmail().contains("@"))
      return "Email must contain '@' character.";
    if (input.getEmail().chars().filter(c -> c == '@').count() > 1)
      return "Email must contain exactly one '@' character";
    if (!input.getEmail().split("@")[1].contains("."))
      return "Email must contain '.' character after '@' character";
    if (input.getEmail().split("@")[1].chars().filter(c -> c == '.').count() > 1)
      return "Email must contain '.' exactly one character after '@' character";
    return "";
  }

  private String validatePassword() {
    if (input.getPassword() == null)
      return "Password must not be null.";
    if (input.getPassword() == "")
      return "Password must not be empty.";
    if (input.getPassword().length() < 10)
      return "Password must be at least 10 characters long.";
    if (!checkContainsSymbol(input.getPassword()))
      return "Password must contain at least one symbol.";
    if (!checkContainsLetter(input.getPassword()))
      return "Password must contain at least one letter.";
    if (!checkContainsNumber(input.getPassword()))
      return "Password must contain at least one number.";
    return "";
  }
}
