package gr.evansp.setup.product.impl.operations;

import gr.evansp.exceptions.DataException;
import gr.evansp.exceptions.LogicException;
import gr.evansp.exceptions.RuleException;
import gr.evansp.factory.Factory;
import gr.evansp.setup.product.def.models.Characteristic;
import gr.evansp.setup.product.def.models.Product;
import gr.evansp.setup.product.def.operations.SaveProductOperation;
import gr.evansp.setup.product.def.persistence.ProductRepository;
import gr.evansp.setup.product.def.questions.NextCharacteristicIdQuestion;
import gr.evansp.setup.product.def.questions.NextProductIdQuestion;
import gr.evansp.setup.product.def.rules.ProductValidator;
import lombok.Getter;
import lombok.Setter;

/**
 * Implementation of {@link SaveProductOperation}
 */
public class SaveProductOperationImpl implements SaveProductOperation {
  @Setter
  @Getter
  Product input;
  ProductValidator validator = Factory.create(ProductValidator.class);
  NextProductIdQuestion nextProductIdQuestion = Factory.create(NextProductIdQuestion.class);
  NextCharacteristicIdQuestion nextCharacteristicIdQuestion = Factory.create(NextCharacteristicIdQuestion.class);
  ProductRepository repository = Factory.create(ProductRepository.class);


  @Override
  public void execute() throws DataException, RuleException, LogicException {
    if (input == null) {
      throw new LogicException("Input(Product) cannot be null.");
    }
    if (input.getProductId() == null) {
      nextProductIdQuestion.ask();
      input.setProductId(nextProductIdQuestion.answer());
      updateCharacteristics();
      validator.setInput(input);
      validator.apply();
      repository.save(input);
      return;
    }
    updateCharacteristics();
    validator.setInput(input);
    validator.apply();
    repository.update(input);
  }

  void updateCharacteristics() throws DataException, LogicException {
    if (input.getCharacteristics() == null) {
      return;
    }
    if (input.getCharacteristics().isEmpty()) {
      return;
    }
    for (Characteristic c : input.getCharacteristics()) {
      if (c.getCharacteristicId() == null) {
        nextCharacteristicIdQuestion.ask();
        c.setCharacteristicId(nextCharacteristicIdQuestion.answer());
      }
      c.setProductId(input.getProductId());
      c.setCategoryId(input.getCategoryId());
    }
  }
}
