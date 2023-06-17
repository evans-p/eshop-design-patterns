package gr.evansp.setup.user.impl.operations;

import gr.evansp.exceptions.DataException;
import gr.evansp.exceptions.LogicException;
import gr.evansp.exceptions.RuleException;
import gr.evansp.factory.Factory;
import gr.evansp.setup.user.def.models.Address;
import gr.evansp.setup.user.def.operations.SaveAddressOperation;
import gr.evansp.setup.user.def.persistence.AddressRepository;
import gr.evansp.setup.user.def.questions.NextAddressIdQuestion;
import gr.evansp.setup.user.def.rules.AddressValidator;
import lombok.Getter;
import lombok.Setter;

/**
 * Implementation of {@link SaveAddressOperation}.
 */
public class SaveAddressOperationImpl implements SaveAddressOperation {
  AddressValidator validator = Factory.create(AddressValidator.class);
  AddressRepository repository = Factory.create(AddressRepository.class);
  NextAddressIdQuestion question = Factory.create(NextAddressIdQuestion.class);

  @Getter
  @Setter
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
      repository.save(input);
      return;
    }
    validator.setInput(input);
    validator.apply();
    repository.update(input);
  }
}
