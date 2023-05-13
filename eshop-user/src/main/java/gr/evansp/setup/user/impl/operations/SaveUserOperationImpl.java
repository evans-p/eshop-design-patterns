package gr.evansp.setup.user.impl.operations;

import gr.evansp.common.DAO;
import gr.evansp.exceptions.DataException;
import gr.evansp.exceptions.LogicException;
import gr.evansp.exceptions.RuleException;
import gr.evansp.factory.Factory;
import gr.evansp.setup.user.def.models.User;
import gr.evansp.setup.user.def.operations.SaveUserOperation;
import gr.evansp.setup.user.def.questions.UserIdExistsQuestion;
import gr.evansp.setup.user.def.rules.UserValidator;


/**
 * Implementation of {@link SaveUserOperation}
 */
public class SaveUserOperationImpl implements SaveUserOperation {
  private User input;

  private UserValidator validator = Factory.create(UserValidator.class);
  private UserIdExistsQuestion question = Factory.create(UserIdExistsQuestion.class);
  private DAO<User> dao = Factory.createPersistence(User.class);

  @Override
  public void execute() throws DataException, RuleException, LogicException {
    if (input == null) {
      throw new LogicException("Input(User) cannot be null.");
    }
    // validate input.
    validator.setInput(input);
    validator.apply();

    question.setInput(input);
    question.ask();

    if (question.answer()) {
      dao.save(input);
    }

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
