package gr.evansp.setup.product.def.rules;

import gr.evansp.exceptions.DataException;
import gr.evansp.exceptions.LogicException;
import gr.evansp.exceptions.RuleException;
import gr.evansp.factory.Factory;
import gr.evansp.setup.product.def.models.Category;
import gr.evansp.setup.product.impl.rules.CategoryValidatorImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Test class for {@link CategoryValidator}
 */
public class TestCategoryValidator {
  private Category category;
  private CategoryValidatorImpl sut = Factory.create(CategoryValidatorImpl.class);

  @Before
  public void setup() {
    category = Mockito.mock(Category.class);

    Mockito.when(category.getCategoryId()).thenReturn(10L);
    Mockito.when(category.getName()).thenReturn("Category");
  }

  @Test
  public void testGetInput() {
    sut.setInput(category);
    Assert.assertEquals(category, sut.getInput());
  }

  @Test
  public void testApply_ok() throws RuleException, DataException, LogicException {
    sut.setInput(category);
    sut.apply();
  }

  @Test(expected = RuleException.class)
  public void testValidateCategoryId_null() throws RuleException, DataException, LogicException {
    Mockito.when(category.getCategoryId()).thenReturn(null);
    sut.setInput(category);
    sut.apply();
  }

  @Test(expected = RuleException.class)
  public void testValidateName_null() throws RuleException, DataException, LogicException {
    Mockito.when(category.getName()).thenReturn(null);
    sut.setInput(category);
    sut.apply();
  }

  @Test(expected = RuleException.class)
  public void testValidateName_empty() throws RuleException, DataException, LogicException {
    Mockito.when(category.getName()).thenReturn("");
    sut.setInput(category);
    sut.apply();
  }
}
