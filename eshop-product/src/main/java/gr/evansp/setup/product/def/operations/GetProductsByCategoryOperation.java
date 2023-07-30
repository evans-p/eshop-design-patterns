package gr.evansp.setup.product.def.operations;

import gr.evansp.common.Operation;
import gr.evansp.setup.product.def.models.Product;

import java.util.List;

/**
 * Gets products that belong to a certain category.
 */
public interface GetProductsByCategoryOperation extends Operation {
    /**
     * Set input.
     */
    void setInput(Long categoryId);

    /**
     * Operation result.
     *
     * @return the products.
     */
    List<Product> getProducts();
}
