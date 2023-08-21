package gr.evansp.setup.product.def.ws.operations;

import gr.evansp.common.Operation;
import gr.evansp.setup.product.def.ws.models.ProductDTO;

import java.util.List;

public interface GetProductsByCategoryWsOperation extends Operation {
    /**
     * Set input.
     */
    void setInput(Long categoryId);

    /**
     * Operation result.
     *
     * @return the products.
     */
    List<ProductDTO> getProducts();
}

