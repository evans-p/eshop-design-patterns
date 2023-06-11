package gr.evansp.setup.product;

import gr.evansp.exceptions.DataException;
import gr.evansp.exceptions.LogicException;
import gr.evansp.exceptions.RuleException;
import gr.evansp.factory.Factory;
import gr.evansp.setup.Setup;
import gr.evansp.setup.product.def.models.Category;
import gr.evansp.setup.product.def.models.Product;
import gr.evansp.setup.product.def.operations.SaveCategoryOperation;
import gr.evansp.setup.product.def.operations.SaveProductOperation;
import gr.evansp.setup.product.def.persistence.ProductRepository;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

/**
 * Integration test class for {@link Product}.
 */
public class TestCRUDProductOperations extends Setup {
  Category category;

  @Before
  public void setUp() throws DataException, LogicException, RuleException {
    category = createSampleCategory(null);
    SaveCategoryOperation categoryOperation = Factory.create(SaveCategoryOperation.class);
    categoryOperation.setInput(category);
    categoryOperation.execute();

  }

  @Test
  public void testCreateNewProduct() throws DataException, LogicException, RuleException {
    Product product = createSampleProduct(null, category.getCategoryId());
    SaveProductOperation sut = Factory.create(SaveProductOperation.class);
    sut.setInput(product);
    sut.execute();
  }

  @Test
  public void testUpdateProduct() throws DataException, LogicException, RuleException {
    Product product = createSampleProduct(null, category.getCategoryId());
    SaveProductOperation sut = Factory.create(SaveProductOperation.class);
    ProductRepository repository = Factory.create(ProductRepository.class);

    sut.setInput(product);
    sut.execute();

    product.setName("new Product Name");
    product.setPrice(new BigDecimal(1000));
    sut.execute();
    //TODO Fix THIS!
    Product returned = repository.get(product.getProductId(), product.getCategoryId());

    assertEquals(new BigDecimal(1000), returned.getPrice());
    assertEquals("new Product Name", returned.getName());
  }
}
