package gr.evansp.setup.product.def.persistence;

import gr.evansp.common.Repository;
import gr.evansp.exceptions.DataException;
import gr.evansp.setup.product.def.models.Product;

public interface ProductRepository extends Repository<Product> {

  Product get(Long productId, Long categoryId) throws DataException;
}
