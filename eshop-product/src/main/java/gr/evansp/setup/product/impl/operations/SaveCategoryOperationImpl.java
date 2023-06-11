package gr.evansp.setup.product.impl.operations;

import gr.evansp.exceptions.DataException;
import gr.evansp.exceptions.LogicException;
import gr.evansp.exceptions.RuleException;
import gr.evansp.factory.Factory;
import gr.evansp.setup.product.def.models.Category;
import gr.evansp.setup.product.def.operations.SaveCategoryOperation;
import gr.evansp.setup.product.def.persistence.CategoryRepository;
import gr.evansp.setup.product.def.questions.NextCategoryIdQuestion;
import gr.evansp.setup.product.def.rules.CategoryValidator;
import lombok.Getter;
import lombok.Setter;

/**
 * Implementation of {@link SaveCategoryOperation}.
 */
public class SaveCategoryOperationImpl implements SaveCategoryOperation {
  @Getter
  @Setter
  Category input;
  CategoryValidator validator = Factory.create(CategoryValidator.class);
  NextCategoryIdQuestion nextCategoryIdQuestion = Factory.create(NextCategoryIdQuestion.class);
  CategoryRepository repository = Factory.create(CategoryRepository.class);

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
      repository.save(input);
      return;
    }
    validator.setInput(input);
    validator.apply();
    repository.update(input);
  }
}
