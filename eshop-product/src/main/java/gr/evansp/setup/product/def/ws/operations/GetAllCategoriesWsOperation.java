package gr.evansp.setup.product.def.ws.operations;

import gr.evansp.common.Operation;
import gr.evansp.setup.product.def.models.Category;

import java.util.List;

public interface GetAllCategoriesWsOperation extends Operation {
  /**
   * Get Result.
   *
   * @return result
   */
  List<Category> getCategories();
}
