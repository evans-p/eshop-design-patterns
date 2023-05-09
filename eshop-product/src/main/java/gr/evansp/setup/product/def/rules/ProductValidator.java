package gr.evansp.setup.product.def.rules;

import gr.evansp.common.Rule;
import gr.evansp.setup.product.def.models.Product;

/**
 * Validator for {@link Product}. Must follow the rules below:
 * <li>product Id must not be null</li>
 * <li>SKU must not be null or empty</li>
 * <li>name must not be null or empty</li>
 * <li>Inventory count must not be null</li>
 * <li>Inventory count must be greater than zero(0).</li>
 * <li>Inventory count must be less or equal to Inventory limit.</li>
 * <li>Inventory limit must not be null</li>
 * <li>Inventory limit must be greater than zero(0).</li>
 * <li>Category must not be null</li>
 * <li>price must not be null</li>
 * <li>price must be greater than zero.</li>
 * <li>dateAdded must not be null</li>
 * <li>dateLastModified must be greater than or equal to dateAdded, if it is not null</li>
 * <li>Product characteristics must not be null or an empty set</li>
 * <li>each product characteristic must be validated, using {@link CharacteristicValidator}</li>
 */
public interface ProductValidator extends Rule<Product> {
  //EMPTY
}
