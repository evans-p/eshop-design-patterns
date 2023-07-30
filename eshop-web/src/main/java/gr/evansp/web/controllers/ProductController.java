package gr.evansp.web.controllers;

import gr.evansp.exceptions.DataException;
import gr.evansp.exceptions.LogicException;
import gr.evansp.exceptions.RuleException;
import gr.evansp.factory.Factory;
import gr.evansp.setup.product.def.ws.models.ProductDTO;
import gr.evansp.setup.product.def.ws.operations.GetAllProductsWsOperation;
import gr.evansp.setup.product.def.ws.operations.GetProductsByCategoryWsOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    private final static String PRODUCT_BASE_URL = "product";

    private final GetAllProductsWsOperation allProductsOperation = Factory.create(GetAllProductsWsOperation.class);
    private final GetProductsByCategoryWsOperation productsByCategoryOperation = Factory.create(
            GetProductsByCategoryWsOperation.class);

    @GetMapping(PRODUCT_BASE_URL + "/all")
    List<ProductDTO> getAllProducts() {
        try {
            allProductsOperation.execute();
            return allProductsOperation.getProducts();
        } catch (DataException | LogicException | RuleException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping(PRODUCT_BASE_URL + "/category/{id}")
    List<ProductDTO> getProductsByCategory(@PathVariable Long id) {
        try {
            productsByCategoryOperation.setInput(id);
            productsByCategoryOperation.execute();
            return productsByCategoryOperation.getProducts();
        } catch (DataException | LogicException | RuleException e) {
            throw new RuntimeException(e);
        }
    }
}
