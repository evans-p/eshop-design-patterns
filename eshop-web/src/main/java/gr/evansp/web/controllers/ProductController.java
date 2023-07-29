package gr.evansp.web.controllers;

import gr.evansp.exceptions.DataException;
import gr.evansp.exceptions.LogicException;
import gr.evansp.exceptions.RuleException;
import gr.evansp.factory.Factory;
import gr.evansp.setup.product.def.ws.models.ProductDTO;
import gr.evansp.setup.product.def.ws.operations.GetAllProductsWsOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    private final static String PRODUCT_BASE_URL = "product";

    private final GetAllProductsWsOperation allProductsOperation = Factory.create(GetAllProductsWsOperation.class);

    @GetMapping(PRODUCT_BASE_URL + "/all")
    List<ProductDTO> getAllProducts() {
        try {
            allProductsOperation.execute();
            return allProductsOperation.getProducts();
        } catch (DataException | LogicException | RuleException e) {
            throw new RuntimeException(e);
        }
    }
}
