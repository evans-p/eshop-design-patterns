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
import java.util.List;

import static org.junit.Assert.*;

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
    ProductRepository repository = Factory.create(ProductRepository.class);
    sut.setInput(product);
    sut.execute();
    assertNotNull(repository.get(product));
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
    product.setInventoryCount(1);
    sut.execute();

    Product returned = repository.get(product);

    assertEquals(Integer.valueOf(1), returned.getInventoryCount());
    assertEquals("new Product Name", returned.getName());
    assertEquals(product, returned);
  }

  @Test
  public void testDeleteProduct() throws DataException, LogicException, RuleException {
    Product product = createSampleProduct(null, category.getCategoryId());
    SaveProductOperation sut = Factory.create(SaveProductOperation.class);
    ProductRepository repository = Factory.create(ProductRepository.class);

    sut.setInput(product);
    sut.execute();

    repository.delete(product);
    assertNull(repository.get(product));
  }

  @Test
  public void testGetAll() throws DataException {
    ProductRepository repository = Factory.create(ProductRepository.class);

    List<Product> products = repository.getAll();

    assertNotNull(products);
    assertFalse(products.isEmpty());
  }
}
