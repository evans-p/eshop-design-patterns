package gr.evansp.product;

import gr.evansp.common.DAO;
import gr.evansp.exceptions.DataException;
import gr.evansp.exceptions.LogicException;
import gr.evansp.exceptions.RuleException;
import gr.evansp.factory.Factory;
import gr.evansp.setup.product.def.models.Category;
import gr.evansp.setup.product.def.models.Product;
import gr.evansp.setup.product.def.operations.SaveCategoryOperation;
import gr.evansp.setup.product.def.operations.SaveProductOperation;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class TestCRUDProductOperations extends Setup {

  @Test
  public void testCreateProduct() throws DataException, LogicException, RuleException {
    Category category = createSampleCategory();
    Product product = createSampleProduct(category);

    SaveCategoryOperation operation = Factory.create(SaveCategoryOperation.class);
    SaveProductOperation sut = Factory.create(SaveProductOperation.class);

    operation.setInput(category);
    operation.execute();

    sut.setInput(product);
    sut.execute();
  }

  @Test
  public void testDeleteProduct() throws DataException, LogicException, RuleException {
    Category category = createSampleCategory();
    Product product = createSampleProduct(category);

    SaveCategoryOperation operation = Factory.create(SaveCategoryOperation.class);
    SaveProductOperation sut = Factory.create(SaveProductOperation.class);
    DAO<Product> dao = Factory.createPersistence(Product.class);

    operation.setInput(category);
    operation.execute();

    sut.setInput(product);
    sut.execute();

    dao.delete(sut.getInput());
    assertNull(dao.get(sut.getInput().getProductId()));
  }

  @Test
  public void testUpdateProduct() throws DataException, LogicException, RuleException {
    Category category = createSampleCategory();
    Product product = createSampleProduct(category);

    SaveCategoryOperation operation = Factory.create(SaveCategoryOperation.class);
    SaveProductOperation sut = Factory.create(SaveProductOperation.class);
    DAO<Product> dao = Factory.createPersistence(Product.class);

    operation.setInput(category);
    operation.execute();

    sut.setInput(product);
    sut.execute();

    Product returned1 = dao.get(sut.getInput().getProductId());
    returned1.setName("LALALALA");
    sut.setInput(returned1);
    sut.execute();

    Product returned2 = dao.get(sut.getInput().getProductId());

    assertEquals(returned2, returned1);
    assertEquals(returned1.getName(), returned2.getName());
  }

  @Test
  public void testGetAllProducts() throws DataException, LogicException, RuleException {
    DAO<Product> dao = Factory.createPersistence(Product.class);

    List<Product> products = dao.getAll();
    Assert.assertTrue(!products.isEmpty());
    Assert.assertTrue(products.size() > 0);
  }
}
