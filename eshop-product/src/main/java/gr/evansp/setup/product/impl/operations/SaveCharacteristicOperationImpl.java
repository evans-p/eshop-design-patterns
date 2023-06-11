package gr.evansp.setup.product.impl.operations;

import gr.evansp.exceptions.DataException;
import gr.evansp.exceptions.LogicException;
import gr.evansp.exceptions.RuleException;
import gr.evansp.factory.Factory;
import gr.evansp.setup.product.def.models.Characteristic;
import gr.evansp.setup.product.def.operations.SaveCharacteristicOperation;
import gr.evansp.setup.product.def.persistence.CharacteristicRepository;
import gr.evansp.setup.product.def.questions.NextCharacteristicIdQuestion;
import gr.evansp.setup.product.def.rules.CharacteristicValidator;
import lombok.Getter;
import lombok.Setter;

/**
 * Implementation of {@link SaveCharacteristicOperation}.
 */
public class SaveCharacteristicOperationImpl implements SaveCharacteristicOperation {
  @Getter
  @Setter
  Characteristic input;
  CharacteristicValidator validator = Factory.create(CharacteristicValidator.class);
  NextCharacteristicIdQuestion nextCharacteristicIdQuestion = Factory.create(NextCharacteristicIdQuestion.class);
  CharacteristicRepository repository = Factory.create(CharacteristicRepository.class);

  @Override
  public void execute() throws DataException, RuleException, LogicException {
    if (input == null) {
      throw new LogicException("Input(Characteristic) cannot be null.");
    }
    if (input.getCharacteristicId() == null) {
      nextCharacteristicIdQuestion.ask();
      input.setCharacteristicId(nextCharacteristicIdQuestion.answer());
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
