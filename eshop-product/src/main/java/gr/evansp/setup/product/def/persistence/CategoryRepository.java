package gr.evansp.setup.product.def.persistence;

import gr.evansp.common.Repository;
import gr.evansp.exceptions.DataException;
import gr.evansp.setup.product.def.models.Category;

/**
 * Repository for {@link Category}
 */
public interface CategoryRepository extends Repository<Category> {
  /**
   * Get category by id.
   *
   * @param id id of category
   * @return category to get.
   * @throws DataException
   */
  Category get(Long id) throws DataException;
}
