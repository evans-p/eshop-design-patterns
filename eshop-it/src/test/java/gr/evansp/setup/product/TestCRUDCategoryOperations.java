package gr.evansp.setup.product;

import gr.evansp.exceptions.DataException;
import gr.evansp.exceptions.LogicException;
import gr.evansp.exceptions.RuleException;
import gr.evansp.factory.Factory;
import gr.evansp.setup.Setup;
import gr.evansp.setup.product.def.models.Category;
import gr.evansp.setup.product.def.operations.SaveCategoryOperation;
import gr.evansp.setup.product.def.persistence.CategoryRepository;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Integration test class for {@link Category}.
 */
public class TestCRUDCategoryOperations extends Setup {
  @Test
  public void testCreateNewCategory() throws DataException, LogicException, RuleException {
    Category category = createSampleCategory(null);
    SaveCategoryOperation sut = Factory.create(SaveCategoryOperation.class);
    sut.setInput(category);
    sut.execute();
  }

  @Test
  public void testUpdateCategory() throws DataException, LogicException, RuleException {
    Category category = createSampleCategory(null);
    SaveCategoryOperation sut = Factory.create(SaveCategoryOperation.class);
    sut.setInput(category);
    sut.execute();

    category.setName("New Name");
    sut.execute();
    CategoryRepository repository = Factory.create(CategoryRepository.class);
    Category returned = repository.get(category);

    assertEquals("New Name", returned.getName());
  }

  @Test
  public void testDeleteCategory() throws DataException, LogicException, RuleException {
    Category category = createSampleCategory(null);
    SaveCategoryOperation sut = Factory.create(SaveCategoryOperation.class);
    CategoryRepository repository = Factory.create(CategoryRepository.class);
    sut.setInput(category);
    sut.execute();

    repository.delete(category);
    assertNull(repository.get(category));
  }

  @Test
  public void testSelectAllCategories() throws DataException {
    CategoryRepository repository = Factory.create(CategoryRepository.class);

    List<Category> categories = repository.getAll();
    assertNotNull(categories);
    assertTrue(categories.size() > 0);
  }
}
