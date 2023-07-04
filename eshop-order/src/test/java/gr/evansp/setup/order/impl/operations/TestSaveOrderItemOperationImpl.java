package gr.evansp.setup.order.impl.operations;

import gr.evansp.exceptions.DataException;
import gr.evansp.exceptions.LogicException;
import gr.evansp.exceptions.RuleException;
import gr.evansp.factory.Factory;
import gr.evansp.setup.order.def.models.OrderItem;
import gr.evansp.setup.order.def.persistence.OrderItemRepository;
import gr.evansp.setup.order.def.rules.OrderItemValidator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;

/**
 * Tests for {@link SaveOrderItemOperationImpl}.
 */
public class TestSaveOrderItemOperationImpl {
  SaveOrderItemOperationImpl sut;

  @Before
  public void setUp() {
    sut = Factory.create(SaveOrderItemOperationImpl.class);
    sut.input = Factory.create(OrderItem.class);
    sut.validator = mock(OrderItemValidator.class);
    sut.repository = mock(OrderItemRepository.class);

    sut.input.setOrderId(1L);
    sut.input.setUserId(1L);
    sut.input.setCategoryId(1L);
    sut.input.setProductId(1L);
    sut.input.setCount(1L);
  }

  /**
   * Test for {@link SaveOrderItemOperationImpl#getInput()}
   */
  @Test
  public void testGetInput() {
    OrderItem orderItem = mock(OrderItem.class);
    sut.setInput(orderItem);
    assertSame(orderItem, sut.getInput());
  }

  /**
   * Test for {@link SaveOrderItemOperationImpl#execute()}
   * null Input.
   */
  @Test(expected = LogicException.class)
  public void testExecute_nullInput() throws DataException, LogicException, RuleException {
    sut.input = null;
    sut.execute();
  }

  /**
   * Test for {@link SaveOrderItemOperationImpl#execute()}
   * null Input.
   */
  @Test
  public void testExecute_ok() throws DataException, LogicException, RuleException {
    sut.execute();
  }
}