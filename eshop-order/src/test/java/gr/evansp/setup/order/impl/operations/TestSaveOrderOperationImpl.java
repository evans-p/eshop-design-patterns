package gr.evansp.setup.order.impl.operations;

import gr.evansp.exceptions.DataException;
import gr.evansp.exceptions.LogicException;
import gr.evansp.exceptions.RuleException;
import gr.evansp.factory.Factory;
import gr.evansp.setup.order.def.models.Order;
import gr.evansp.setup.order.def.persistence.OrderRepository;
import gr.evansp.setup.order.def.questions.NextOrderIdQuestion;
import gr.evansp.setup.order.def.rules.OrderValidator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;

/**
 * Tests for {@link SaveOrderOperationImpl}.
 */
public class TestSaveOrderOperationImpl {
  private SaveOrderOperationImpl sut;

  @Before
  public void setUp() {
    sut = Factory.create(SaveOrderOperationImpl.class);
    sut.input = Factory.create(Order.class);
    sut.validator = mock(OrderValidator.class);
    sut.question = mock(NextOrderIdQuestion.class);
    sut.repository = mock(OrderRepository.class);

    sut.input.setOrderId(1L);
  }

  /**
   * Test for {@link SaveOrderOperationImpl#getInput()}
   */
  @Test
  public void testGetInput() {
    Order order = mock(Order.class);
    sut.setInput(order);
    assertSame(order, sut.getInput());
  }

  /**
   * Test for {@link SaveOrderOperationImpl#execute()}
   * null Input.
   */
  @Test(expected = LogicException.class)
  public void testExecute_nullInput() throws DataException, LogicException, RuleException {
    sut.input = null;
    sut.execute();
  }

  /**
   * Test for {@link SaveOrderOperationImpl#execute()}
   * no cart Id.
   */
  @Test
  public void testExecute_noCartID() throws DataException, LogicException, RuleException {
    sut.input.setOrderId(null);
    sut.execute();
  }

  /**
   * Test for {@link SaveOrderOperationImpl#execute()}
   * ok.
   */
  @Test
  public void testExecute_ok() throws DataException, LogicException, RuleException {
    sut.execute();
  }

}