package gr.evansp.setup.product.impl.operations;

import gr.evansp.common.DAO;
import gr.evansp.exceptions.DataException;
import gr.evansp.exceptions.LogicException;
import gr.evansp.exceptions.RuleException;
import gr.evansp.factory.Factory;
import gr.evansp.setup.product.def.models.Characteristic;
import gr.evansp.setup.product.def.models.Product;
import gr.evansp.setup.product.def.operations.SaveProductOperation;
import gr.evansp.setup.product.def.questions.NextCharacteristicIdQuestion;
import gr.evansp.setup.product.def.questions.NextProductIdQuestion;
import gr.evansp.setup.product.def.rules.ProductValidator;

/**
 * Implementation of {@link SaveProductOperation}
 */
public class SaveProductOperationImpl implements SaveProductOperation {
  Product input;
  ProductValidator validator = Factory.create(ProductValidator.class);
  NextProductIdQuestion nextProductIdQuestion = Factory.create(NextProductIdQuestion.class);
  NextCharacteristicIdQuestion characteristicIdQuestion = Factory.create(NextCharacteristicIdQuestion.class);
  DAO<Product> dao = Factory.createPersistence(Product.class);

  @Override
  public Product getInput() {
    return input;
  }

  @Override
  public void setInput(Product input) {
    this.input = input;
  }

  @Override
  public void execute() throws DataException, RuleException, LogicException {
    if (input == null) {
      throw new LogicException("Input(Product) cannot be null.");
    }
    updateCharacteristics(input);
    if (input.getProductId() == null) {
      nextProductIdQuestion.ask();
      input.setProductId(nextProductIdQuestion.answer());
      validator.setInput(input);
      validator.apply();
      dao.save(input);
    }
    validator.setInput(input);
    validator.apply();
    dao.update(input);
  }

  /**
   * Checks if input's characteristics have Id and product, and if the do not,
   * fills them.
   *
   * @param product input
   * @throws DataException
   * @throws LogicException
   */
  private void updateCharacteristics(Product product) throws DataException, LogicException {
    for (Characteristic c : product.getCharacteristics()) {
      if (c.getProduct() == null) {
        c.setProduct(product);
      }
      if (c.getCharacteristicId() == null) {
        characteristicIdQuestion.ask();
        c.setCharacteristicId(characteristicIdQuestion.answer());
      }
    }
  }
}
