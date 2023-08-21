package gr.evansp.setup.product.impl.ws.operations;

import gr.evansp.exceptions.DataException;
import gr.evansp.exceptions.LogicException;
import gr.evansp.exceptions.RuleException;
import gr.evansp.factory.Factory;
import gr.evansp.setup.product.def.models.Product;
import gr.evansp.setup.product.def.operations.GetProductsByCategoryOperation;
import gr.evansp.setup.product.def.ws.models.ProductDTO;
import gr.evansp.setup.product.def.ws.operations.GetProductsByCategoryWsOperation;
import gr.evansp.setup.product.def.ws.transformations.ProductToProductDTOTransformation;

import java.util.ArrayList;
import java.util.List;

public class GetProductsByCategoryWsOperationImpl implements GetProductsByCategoryWsOperation {
    List<ProductDTO> products = new ArrayList<>();
    Long categoryId;
    ProductToProductDTOTransformation transformation = Factory.create(ProductToProductDTOTransformation.class);
    GetProductsByCategoryOperation operation = Factory.create(GetProductsByCategoryOperation.class);

    @Override
    public void execute() throws DataException, RuleException, LogicException {
        if (categoryId == null) {
            throw new LogicException("Input cannot be null");
        }
        operation.setInput(categoryId);
        operation.execute();

        for (Product product : operation.getProducts()) {
            transformation.setInput(product);
            transformation.transform();
            products.add(transformation.getOutput());
        }
    }

    @Override
    public void setInput(Long categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public List<ProductDTO> getProducts() {
        return products;
    }
}
