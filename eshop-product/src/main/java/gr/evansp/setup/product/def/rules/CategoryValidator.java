package gr.evansp.setup.product.def.rules;

import gr.evansp.common.Rule;
import gr.evansp.setup.product.def.models.Category;

/**
 * Validator for {@link Category}. To be valid the category must
 * follow the rules below:
 * <li>categoryId must not be null</li>
 * <li>name must not be null or empty</li>
 */
public interface CategoryValidator extends Rule<Category> {
  //EMPTY
}
