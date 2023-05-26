package gr.evansp.setup.product.impl.operations;

import gr.evansp.common.DAO;
import gr.evansp.exceptions.DataException;
import gr.evansp.exceptions.LogicException;
import gr.evansp.exceptions.RuleException;
import gr.evansp.factory.Factory;
import gr.evansp.setup.product.def.models.Product;
import gr.evansp.setup.product.def.questions.NextProductIdQuestion;
import gr.evansp.setup.product.def.rules.ProductValidator;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.*;

/**
 * Tester for {@link SaveProductOperationImpl}
 */
public class TestSaveProductOperationImpl {
  SaveProductOperationImpl sut;

  @Before
  public void setUp() throws DataException, LogicException, RuleException {
    sut = Factory.create(SaveProductOperationImpl.class);
    sut.dao = mock(DAO.class);
    sut.nextProductIdQuestion = mock(NextProductIdQuestion.class);
    sut.validator = mock(ProductValidator.class);
    sut.input = mock(Product.class);

    doNothing().when(sut.nextProductIdQuestion).ask();
    when(sut.nextProductIdQuestion.answer()).thenReturn(1L);
    doNothing().when(sut.validator).apply();
    doNothing().when(sut.dao).save(isA(Product.class));
    doNothing().when(sut.dao).update(isA(Product.class));
  }

  @Test(expected = LogicException.class)
  public void testExecute_null() throws DataException, LogicException, RuleException {
    sut.setInput(null);
    sut.execute();
  }

  @Test
  public void testExecute_new() throws DataException, LogicException, RuleException {
    when(sut.getInput().getProductId()).thenReturn(null);
    sut.execute();
  }

  @Test
  public void testExecute_update() throws DataException, LogicException, RuleException {
    when(sut.getInput().getProductId()).thenReturn(1L);
    sut.execute();
  }
}