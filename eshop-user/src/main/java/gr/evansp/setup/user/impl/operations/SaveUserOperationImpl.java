package gr.evansp.setup.user.impl.operations;

import gr.evansp.common.DAO;
import gr.evansp.exceptions.DataException;
import gr.evansp.exceptions.LogicException;
import gr.evansp.exceptions.RuleException;
import gr.evansp.factory.Factory;
import gr.evansp.setup.user.def.models.User;
import gr.evansp.setup.user.def.operations.SaveUserOperation;
import gr.evansp.setup.user.def.questions.NextUserIdQuestion;
import gr.evansp.setup.user.def.rules.UserValidator;


/**
 * Implementation of {@link SaveUserOperation}
 */
public class SaveUserOperationImpl implements SaveUserOperation {
  UserValidator validator = Factory.create(UserValidator.class);
  NextUserIdQuestion nextUserIdQuestion = Factory.create(NextUserIdQuestion.class);
  DAO<User> dao = Factory.createPersistence(User.class);
  User input;

  @Override
  public void execute() throws DataException, RuleException, LogicException {
    if (input == null) {
      throw new LogicException("Input(User) cannot be null.");
    }
    if (input.getUserId() == null) {
      nextUserIdQuestion.ask();
      Long id = nextUserIdQuestion.answer();
      input.setUserId(id);
      if (input.getUserProfile() != null) {
        input.getUserProfile().setUserId(id);
      }
      saveNewUser();
      return;
    }
    if (input.getUserProfile() != null) {
      input.getUserProfile().setUserId(input.getUserId());
    }
    // Validate input.
    validator.setInput(input);
    validator.apply();
    dao.update(input);
  }

  private void saveNewUser() throws RuleException, DataException, LogicException {
    // Validate input.
    validator.setInput(input);
    validator.apply();

    dao.save(input);
  }

  @Override
  public User getInput() {
    return input;
  }

  @Override
  public void setInput(User input) {
    this.input = input;
  }
}
