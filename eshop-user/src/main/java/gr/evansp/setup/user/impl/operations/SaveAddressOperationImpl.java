package gr.evansp.setup.user.impl.operations;

import gr.evansp.common.DAO;
import gr.evansp.exceptions.DataException;
import gr.evansp.exceptions.LogicException;
import gr.evansp.exceptions.RuleException;
import gr.evansp.factory.Factory;
import gr.evansp.setup.user.def.models.Address;
import gr.evansp.setup.user.def.operations.SaveAddressOperation;
import gr.evansp.setup.user.def.questions.NextAddressIdQuestion;
import gr.evansp.setup.user.def.rules.AddressValidator;

/**
 * Implementation of {@link SaveAddressOperation}
 */
public class SaveAddressOperationImpl implements SaveAddressOperation {
  public AddressValidator validator = Factory.create(AddressValidator.class);
  public DAO<Address> dao = Factory.createPersistence(Address.class);
  public NextAddressIdQuestion question = Factory.create(NextAddressIdQuestion.class);

  Address input;

  @Override
  public void execute() throws DataException, RuleException, LogicException {
    if (input == null) {
      throw new LogicException("Input(Address) cannot be null.");
    }
    if (input.getAddressId() == null) {
      question.ask();
      input.setAddressId(question.answer());
      validator.setInput(input);
      validator.apply();
      dao.save(input);
    }
    validator.setInput(input);
    validator.apply();
    dao.update(input);
  }

  @Override
  public Address getInput() {
    return input;
  }

  @Override
  public void setInput(Address input) {
    this.input = input;
  }
}
