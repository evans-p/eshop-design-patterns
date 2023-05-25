package gr.evansp.setup.product.impl.operations;

import gr.evansp.common.DAO;
import gr.evansp.exceptions.DataException;
import gr.evansp.exceptions.LogicException;
import gr.evansp.exceptions.RuleException;
import gr.evansp.factory.Factory;
import gr.evansp.setup.product.def.models.Category;
import gr.evansp.setup.product.def.operations.SaveCategoryOperation;
import gr.evansp.setup.product.def.questions.NextCategoryIdQuestion;
import gr.evansp.setup.product.def.rules.CategoryValidator;

public class SaveCategoryOperationImpl implements SaveCategoryOperation {
  Category input;
  CategoryValidator validator = Factory.create(CategoryValidator.class);
  NextCategoryIdQuestion nextCategoryIdQuestion = Factory.create(NextCategoryIdQuestion.class);
  DAO<Category> dao = Factory.createPersistence(Category.class);

  @Override
  public void execute() throws DataException, RuleException, LogicException {
    if (input == null) {
      throw new LogicException("Input(Category) cannot be null.");
    }
    if (input.getCategoryId() == null) {
      nextCategoryIdQuestion.ask();
      input.setCategoryId(nextCategoryIdQuestion.answer());
      validator.setInput(input);
      validator.apply();
      dao.save(input);
    }
    validator.setInput(input);
    validator.apply();
    dao.update(input);
  }

  @Override
  public Category getInput() {
    return input;
  }

  @Override
  public void setInput(Category input) {
    this.input = input;
  }
}
