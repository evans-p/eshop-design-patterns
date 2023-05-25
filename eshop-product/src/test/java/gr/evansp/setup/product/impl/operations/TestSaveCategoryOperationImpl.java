package gr.evansp.setup.product.impl.operations;

import gr.evansp.common.DAO;
import gr.evansp.exceptions.DataException;
import gr.evansp.exceptions.LogicException;
import gr.evansp.exceptions.RuleException;
import gr.evansp.factory.Factory;
import gr.evansp.setup.product.def.models.Category;
import gr.evansp.setup.product.def.questions.NextCategoryIdQuestion;
import gr.evansp.setup.product.def.rules.CategoryValidator;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class TestSaveCategoryOperationImpl {
  SaveCategoryOperationImpl sut;

  @Before
  public void setUp() throws DataException, LogicException, RuleException {
    sut = Factory.create(SaveCategoryOperationImpl.class);
    sut.dao = mock(DAO.class);
    sut.nextCategoryIdQuestion = mock(NextCategoryIdQuestion.class);
    sut.validator = mock(CategoryValidator.class);
    sut.input = mock(Category.class);

    sut.setInput(mock(Category.class));
    doNothing().when(sut.nextCategoryIdQuestion).ask();
    when(sut.nextCategoryIdQuestion.answer()).thenReturn(1L);
    doNothing().when(sut.validator).apply();
    doNothing().when(sut.dao).save(isA(Category.class));
    doNothing().when(sut.dao).update(isA(Category.class));
  }

  @Test(expected = LogicException.class)
  public void testExecute_null() throws DataException, LogicException, RuleException {
    sut.setInput(null);
    sut.execute();
  }

  @Test
  public void testExecute_new() throws DataException, LogicException, RuleException {
    when(sut.getInput().getCategoryId()).thenReturn(null);
    sut.execute();
  }

  @Test
  public void testExecute_update() throws DataException, LogicException, RuleException {
    when(sut.getInput().getCategoryId()).thenReturn(1L);
    sut.execute();
  }
}