package gr.evansp.setup.product.impl.operations;

import gr.evansp.exceptions.DataException;
import gr.evansp.exceptions.LogicException;
import gr.evansp.exceptions.RuleException;
import gr.evansp.factory.Factory;
import gr.evansp.setup.product.def.models.Product;
import gr.evansp.setup.product.def.operations.GetProductsByCategoryOperation;
import gr.evansp.setup.product.def.persistence.ProductRepository;

import java.util.List;

/**
 * Implementation of {@link GetProductsByCategoryOperation}.
 */
public class GetProductsByCategoryOperationImpl implements GetProductsByCategoryOperation {
    Long categoryId;
    List<Product> products;
    ProductRepository repository = Factory.create(ProductRepository.class);

    @Override
    public void execute() throws DataException, RuleException, LogicException {
        if (categoryId == null) {
            throw new LogicException("Input cannot be null");
        }
        products = repository.getByCategory(categoryId);
    }

    @Override
    public void setInput(Long categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public List<Product> getProducts() {
        return products;
    }
}
