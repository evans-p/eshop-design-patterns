package gr.evansp.setup.product.def.persistence;

import gr.evansp.common.Repository;
import gr.evansp.exceptions.DataException;
import gr.evansp.setup.product.def.models.Product;

import java.util.List;

public interface ProductRepository extends Repository<Product> {
    //EMPTY
    List<Product> getByCategory(Long categoryId) throws DataException;
}
