package gr.evansp.setup.product.impl.operations;

import gr.evansp.exceptions.DataException;
import gr.evansp.exceptions.LogicException;
import gr.evansp.exceptions.RuleException;
import gr.evansp.factory.Factory;
import gr.evansp.setup.product.def.models.Category;
import gr.evansp.setup.product.def.persistence.CategoryRepository;
import gr.evansp.setup.product.def.questions.NextCategoryIdQuestion;
import gr.evansp.setup.product.def.rules.CategoryValidator;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

/**
 * Tests for {@link SaveCategoryOperationImpl}
 */
public class TestSaveCategoryOperationImpl {
  SaveCategoryOperationImpl sut;

  @Before
  public void setUp() throws DataException, LogicException, RuleException {
    sut = Factory.create(SaveCategoryOperationImpl.class);
    sut.repository = mock(CategoryRepository.class);
    sut.nextCategoryIdQuestion = mock(NextCategoryIdQuestion.class);
    sut.validator = mock(CategoryValidator.class);
    sut.input = mock(Category.class);

    doNothing().when(sut.nextCategoryIdQuestion).ask();
    when(sut.nextCategoryIdQuestion.answer()).thenReturn(1L);
    doNothing().when(sut.validator).setInput(isA(Category.class));
    doNothing().when(sut.validator).apply();
    doNothing().when(sut.repository).save(isA(Category.class));
    doNothing().when(sut.repository).update(isA(Category.class));
  }

  @Test(expected = LogicException.class)
  public void testExecute_null() throws DataException, LogicException, RuleException {
    sut.setInput(null);
    sut.execute();
  }

  @Test
  public void testExecute_new() throws DataException, LogicException, RuleException {
    when(sut.input.getCategoryId()).thenReturn(null);
    sut.execute();

    verify(sut.nextCategoryIdQuestion, times(1)).ask();
    verify(sut.nextCategoryIdQuestion, times(1)).answer();
    verify(sut.validator, times(1)).setInput(isA(Category.class));
    verify(sut.validator, times(1)).apply();
    verify(sut.repository, times(1)).save(isA(Category.class));
    verify(sut.repository, times(0)).update(isA(Category.class));
  }

  @Test
  public void testExecute_update() throws DataException, LogicException, RuleException {
    when(sut.getInput().getCategoryId()).thenReturn(1L);
    sut.execute();
    verify(sut.nextCategoryIdQuestion, times(0)).ask();
    verify(sut.nextCategoryIdQuestion, times(0)).answer();
    verify(sut.validator, times(1)).setInput(isA(Category.class));
    verify(sut.validator, times(1)).apply();
    verify(sut.repository, times(0)).save(isA(Category.class));
    verify(sut.repository, times(1)).update(isA(Category.class));
  }
}