package gr.evansp.setup.user.impl.rules;

import gr.evansp.constants.StringConstants;
import gr.evansp.exceptions.DataException;
import gr.evansp.exceptions.LogicException;
import gr.evansp.exceptions.RuleException;
import gr.evansp.factory.Factory;
import gr.evansp.setup.user.def.models.User;
import gr.evansp.setup.user.def.questions.UserEmailExistsQuestion;
import gr.evansp.setup.user.def.rules.UserProfileValidator;
import gr.evansp.setup.user.def.rules.UserValidator;
import lombok.Getter;
import lombok.Setter;

import static gr.evansp.rules.RuleUtils.*;


/**
 * implementation of {@link UserValidator}.
 */
public class UserValidatorImpl implements UserValidator {

  @Setter
  @Getter
  User input;

  UserEmailExistsQuestion question = Factory.create(UserEmailExistsQuestion.class);
  UserProfileValidator validator = Factory.create(UserProfileValidator.class);

  @Override
  public void apply() throws RuleException, DataException, LogicException {
    StringBuilder builder = new StringBuilder();

    builder.append(validateUserId());
    builder.append(validateEmail());
    builder.append(validatePassword());
    builder.append(validateUserProfile());

    if (builder.toString().length() > 0) {
      throw new RuleException(builder.toString());
    }

    validator.setInput(input.getUserProfile());
    validator.apply();
  }

  private String validateUserProfile() {
    if (input.getUserProfile() == null) {
      return "UserProfile must not be null";
    }
    return StringConstants.EMPTY;
  }

  private String validateUserId() {
    if (input.getUserId() == null) {
      return "UserId must not be null";
    }
    return StringConstants.EMPTY;
  }

  private String validateEmail() throws DataException, LogicException {
    if (input.getEmail() == null) {
      return "Email must not be null.";
    }
    if (input.getEmail().equals(StringConstants.EMPTY)) {
      return "Email must not be empty.";
    }
    if (!input.getEmail().contains("@")) {
      return "Email must contain '@' character.";
    }
    if (input.getEmail().chars().filter(c -> c == '@').count() > 1) {
      return "Email must contain exactly one '@' character";
    }
    if (!input.getEmail().split("@")[1].contains(".")) {
      return "Email must contain '.' character after '@' character";
    }
    if (input.getEmail().split("@")[1].chars().filter(c -> c == '.').count() > 1) {
      return "Email must contain '.' exactly one character after '@' character";
    }
    question.setInput(input);
    question.ask();
    if (question.answer()) {
      return "Email must be unique";
    }
    return StringConstants.EMPTY;
  }

  private String validatePassword() {
    if (input.getPassword() == null) {
      return "Password must not be null.";
    }
    if (input.getPassword().equals(StringConstants.EMPTY)) {
      return "Password must not be empty.";
    }
    if (input.getPassword().length() < 10) {
      return "Password must be at least 10 characters long.";
    }
    if (!checkContainsSymbol(input.getPassword())) {
      return "Password must contain at least one symbol.";
    }
    if (!checkContainsLetter(input.getPassword())) {
      return "Password must contain at least one letter.";
    }
    if (!checkContainsNumber(input.getPassword())) {
      return "Password must contain at least one number.";
    }
    return StringConstants.EMPTY;
  }
}
