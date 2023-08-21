package gr.evansp.setup.product.def.operations;

import gr.evansp.common.Operation;
import gr.evansp.setup.product.def.models.Category;

import java.util.List;

/**
 * Get all categories from DB.
 */
public interface GetAllCategoriesOperation extends Operation {
  /**
   * Get Result.
   *
   * @return result
   */
  List<Category> getCategories();
}
