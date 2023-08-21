package gr.evansp.setup.product.impl.operations;

import gr.evansp.exceptions.DataException;
import gr.evansp.exceptions.LogicException;
import gr.evansp.exceptions.RuleException;
import gr.evansp.factory.Factory;
import gr.evansp.setup.product.def.models.Category;
import gr.evansp.setup.product.def.operations.GetAllCategoriesOperation;
import gr.evansp.setup.product.def.persistence.CategoryRepository;

import java.util.List;

/**
 * Implementation of {@link GetAllCategoriesOperation}.
 */
public class GetAllCategoriesOperationImpl implements GetAllCategoriesOperation {
  List<Category> categories;
  CategoryRepository repository = Factory.create(CategoryRepository.class);

  @Override
  public void execute() throws DataException, RuleException, LogicException {

    categories = repository.getAll();

  }

  @Override
  public List<Category> getCategories() {
    return categories;
  }
}
