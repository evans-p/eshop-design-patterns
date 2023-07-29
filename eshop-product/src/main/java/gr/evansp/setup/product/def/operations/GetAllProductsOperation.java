package gr.evansp.setup.product.def.operations;

import gr.evansp.common.Operation;
import gr.evansp.setup.product.def.models.Product;

import java.util.List;

/**
 * Operation to get all products from DB.
 */
public interface GetAllProductsOperation extends Operation {
    /**
     * Operation result.
     *
     * @return the products.
     */
    List<Product> getProducts();
}
