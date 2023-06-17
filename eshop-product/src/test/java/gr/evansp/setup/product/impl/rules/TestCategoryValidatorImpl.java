package gr.evansp.setup.product.impl.rules;

import gr.evansp.constants.StringConstants;
import gr.evansp.exceptions.RuleException;
import gr.evansp.factory.Factory;
import gr.evansp.setup.product.def.models.Category;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Test class for {@link CategoryValidatorImpl}
 */
public class TestCategoryValidatorImpl {
  private final CategoryValidatorImpl sut = Factory.create(CategoryValidatorImpl.class);
  private Category category;

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
  public void testApply_ok() throws RuleException {
    sut.setInput(category);
    sut.apply();
  }

  @Test(expected = RuleException.class)
  public void testValidateCategoryId_null() throws RuleException {
    Mockito.when(category.getCategoryId()).thenReturn(null);
    sut.setInput(category);
    sut.apply();
  }

  @Test(expected = RuleException.class)
  public void testValidateName_null() throws RuleException {
    Mockito.when(category.getName()).thenReturn(null);
    sut.setInput(category);
    sut.apply();
  }

  @Test(expected = RuleException.class)
  public void testValidateName_empty() throws RuleException {
    Mockito.when(category.getName()).thenReturn(StringConstants.EMPTY);
    sut.setInput(category);
    sut.apply();
  }
}
