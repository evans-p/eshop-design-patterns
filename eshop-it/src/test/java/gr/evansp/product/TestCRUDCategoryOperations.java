package gr.evansp.product;

import gr.evansp.common.DAO;
import gr.evansp.exceptions.DataException;
import gr.evansp.exceptions.LogicException;
import gr.evansp.exceptions.RuleException;
import gr.evansp.factory.Factory;
import gr.evansp.setup.product.def.models.Category;
import gr.evansp.setup.product.def.operations.SaveCategoryOperation;
import gr.evansp.setup.user.def.models.User;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Integration test class for {@link User}.
 */

public class TestCRUDCategoryOperations extends Setup {

  @Test
  public void testCreateCategory() throws DataException, LogicException, RuleException {
    Category category = createSampleCategory();
    SaveCategoryOperation sut = Factory.create(SaveCategoryOperation.class);

    sut.setInput(category);
    sut.execute();
  }

  @Test
  public void testUpdateCategory() throws DataException, LogicException, RuleException {
    Category category = createSampleCategory();
    DAO<Category> dao = Factory.createPersistence(Category.class);
    SaveCategoryOperation sut = Factory.create(SaveCategoryOperation.class);

    sut.setInput(category);
    sut.execute();


    category = dao.get(sut.getInput().getCategoryId());
    category.setName("asdasdasdad");
    sut.setInput(category);
    sut.execute();

    Category returned = dao.get(sut.getInput().getCategoryId());
    assertEquals(returned, category);
    assertEquals(returned.getName(), "asdasdasdad");
  }

  @Test
  public void testDeleteCategory() throws DataException, LogicException, RuleException {
    Category category = createSampleCategory();
    DAO<Category> dao = Factory.createPersistence(Category.class);
    SaveCategoryOperation sut = Factory.create(SaveCategoryOperation.class);

    sut.setInput(category);
    sut.execute();
    Long id = sut.getInput().getCategoryId();
    dao.delete(sut.getInput());

    assertNull(dao.get(id));
  }

  @Test
  public void testGetAllCategories() throws DataException, LogicException, RuleException {
    DAO<Category> dao = Factory.createPersistence(Category.class);

    List<Category> categories = dao.getAll();
    Assert.assertTrue(!categories.isEmpty());
    Assert.assertTrue(categories.size() > 0);
  }
}
