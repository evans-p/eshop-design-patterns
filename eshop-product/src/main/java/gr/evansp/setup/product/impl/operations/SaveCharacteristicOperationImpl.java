package gr.evansp.setup.product.impl.operations;

import gr.evansp.common.DAO;
import gr.evansp.exceptions.DataException;
import gr.evansp.exceptions.LogicException;
import gr.evansp.exceptions.RuleException;
import gr.evansp.factory.Factory;
import gr.evansp.setup.product.def.models.Characteristic;
import gr.evansp.setup.product.def.operations.SaveCharacteristicOperation;
import gr.evansp.setup.product.def.questions.NextCharacteristicIdQuestion;
import gr.evansp.setup.product.def.rules.CharacteristicValidator;

public class SaveCharacteristicOperationImpl implements SaveCharacteristicOperation {
  Characteristic input;
  CharacteristicValidator validator = Factory.create(CharacteristicValidator.class);
  NextCharacteristicIdQuestion nextCharacteristicIdQuestion = Factory.create(NextCharacteristicIdQuestion.class);
  DAO<Characteristic> dao = Factory.createPersistence(Characteristic.class);

  @Override
  public Characteristic getInput() {
    return input;
  }

  @Override
  public void setInput(Characteristic input) {
    this.input = input;
  }

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
      dao.save(input);
    }
    validator.setInput(input);
    validator.apply();
    dao.update(input);
  }
}
