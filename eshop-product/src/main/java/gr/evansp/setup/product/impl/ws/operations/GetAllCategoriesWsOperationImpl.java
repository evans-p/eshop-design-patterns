package gr.evansp.setup.product.impl.ws.operations;

import gr.evansp.exceptions.DataException;
import gr.evansp.exceptions.LogicException;
import gr.evansp.exceptions.RuleException;
import gr.evansp.factory.Factory;
import gr.evansp.setup.product.def.models.Category;
import gr.evansp.setup.product.def.operations.GetAllCategoriesOperation;
import gr.evansp.setup.product.def.ws.operations.GetAllCategoriesWsOperation;

import java.util.List;

/**
 * Implementation of {@link GetAllCategoriesWsOperation}.
 */
public class GetAllCategoriesWsOperationImpl implements GetAllCategoriesWsOperation {
  List<Category> categories;
  GetAllCategoriesOperation operation = Factory.create(GetAllCategoriesOperation.class);

  @Override
  public void execute() throws DataException, RuleException, LogicException {
    operation.execute();
    categories = operation.getCategories();

  }

  @Override
  public List<Category> getCategories() {
    return categories;
  }
}
