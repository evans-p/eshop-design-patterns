package gr.evansp.setup.order.impl.operations;

import gr.evansp.exceptions.DataException;
import gr.evansp.exceptions.LogicException;
import gr.evansp.exceptions.RuleException;
import gr.evansp.factory.Factory;
import gr.evansp.setup.order.def.models.CartItem;
import gr.evansp.setup.order.def.persistence.CartItemRepository;
import gr.evansp.setup.order.def.rules.CartItemValidator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;

/**
 * Tests for {@link SaveCartItemOperationImpl}.
 */
public class TestSaveCartItemOperationImpl {
  SaveCartItemOperationImpl sut;

  @Before
  public void setUp() {
    sut = Factory.create(SaveCartItemOperationImpl.class);
    sut.input = Factory.create(CartItem.class);
    sut.validator = mock(CartItemValidator.class);
    sut.repository = mock(CartItemRepository.class);

    sut.input.setCartId(1L);
    sut.input.setCategoryId(1L);
    sut.input.setProductId(1L);
    sut.input.setCount(1L);
  }

  /**
   * Test for {@link SaveCartItemOperationImpl#getInput()}
   */
  @Test
  public void testGetInput() {
    CartItem cart = mock(CartItem.class);
    sut.setInput(cart);
    assertSame(cart, sut.getInput());
  }


  /**
   * Test for {@link SaveCartItemOperationImpl#execute()}
   * null Input.
   */
  @Test(expected = LogicException.class)
  public void testExecute_nullInput() throws DataException, LogicException, RuleException {
    sut.input = null;
    sut.execute();
  }


  /**
   * Test for {@link SaveCartItemOperationImpl#execute()}
   * null Input.
   */
  @Test
  public void testExecute_ok() throws DataException, LogicException, RuleException {
    sut.execute();
  }
}