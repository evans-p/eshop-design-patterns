package gr.evansp.setup.product.impl.ws.operations;

import gr.evansp.exceptions.DataException;
import gr.evansp.exceptions.LogicException;
import gr.evansp.exceptions.RuleException;
import gr.evansp.factory.Factory;
import gr.evansp.setup.product.def.models.Product;
import gr.evansp.setup.product.def.operations.GetAllProductsOperation;
import gr.evansp.setup.product.def.ws.models.ProductDTO;
import gr.evansp.setup.product.def.ws.operations.GetAllProductsWsOperation;
import gr.evansp.setup.product.def.ws.transformations.ProductToProductDTOTransformation;

import java.util.ArrayList;
import java.util.List;

public class GetAllProductsWsOperationImpl implements GetAllProductsWsOperation {
    List<ProductDTO> products = new ArrayList<>();
    ProductToProductDTOTransformation transformation = Factory.create(ProductToProductDTOTransformation.class);
    GetAllProductsOperation operation = Factory.create(GetAllProductsOperation.class);

    @Override
    public void execute() throws DataException, RuleException, LogicException {
        operation.execute();

        for (Product product : operation.getProducts()) {
            transformation.setInput(product);
            transformation.transform();
            products.add(transformation.getOutput());
        }
    }

    @Override
    public List<ProductDTO> getProducts() {
        return products;
    }
}
