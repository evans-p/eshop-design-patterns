package gr.evansp.setup.user.impl.operations;

import gr.evansp.common.DAO;
import gr.evansp.exceptions.DataException;
import gr.evansp.exceptions.LogicException;
import gr.evansp.exceptions.RuleException;
import gr.evansp.factory.Factory;
import gr.evansp.setup.user.def.models.User;
import gr.evansp.setup.user.def.operations.SaveUserOperation;
import gr.evansp.setup.user.def.questions.NextUserIdQuestion;
import gr.evansp.setup.user.def.questions.UserIdExistsQuestion;
import gr.evansp.setup.user.def.rules.UserValidator;


/**
 * Implementation of {@link SaveUserOperation}
 */
public class SaveUserOperationImpl implements SaveUserOperation {
  public UserValidator validator = Factory.create(UserValidator.class);
  public UserIdExistsQuestion idExistsQuestion = Factory.create(UserIdExistsQuestion.class);
  public NextUserIdQuestion nextUserIdQuestion = Factory.create(NextUserIdQuestion.class);
  public DAO<User> dao = Factory.createPersistence(User.class);
  User input;

  @Override
  public void execute() throws DataException, RuleException, LogicException {
    if (input == null) {
      throw new LogicException("Input(User) cannot be null.");
    }

    if (input.getUserId() == null) {
      nextUserIdQuestion.ask();
      input.setUserId(nextUserIdQuestion.answer());
      saveNewUser();
      return;
    }
    // Validate input.
    validator.setInput(input);
    validator.apply();
    // Check if user PK already exists in User DB table(TBUSER).
    idExistsQuestion.setInput(input);
    idExistsQuestion.ask();

    if (idExistsQuestion.answer()) {
      // user Id already exists.
      dao.update(input);
    } else {
      dao.save(input);
    }
  }

  private void saveNewUser() throws RuleException, DataException {
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
