package gr.evansp.setup.product.impl.operations;

import gr.evansp.exceptions.DataException;
import gr.evansp.exceptions.LogicException;
import gr.evansp.exceptions.RuleException;
import gr.evansp.factory.Factory;
import gr.evansp.setup.product.def.models.Product;
import gr.evansp.setup.product.def.operations.GetAllProductsOperation;
import gr.evansp.setup.product.def.persistence.ProductRepository;

import java.util.List;

public class GetAllProductsOperationImpl implements GetAllProductsOperation {

    ProductRepository repository = Factory.create(ProductRepository.class);
    private List<Product> products;

    @Override
    public void execute() throws DataException, RuleException, LogicException {
        products = repository.getAll();
    }

    @Override
    public List<Product> getProducts() {
        return products;
    }
}
