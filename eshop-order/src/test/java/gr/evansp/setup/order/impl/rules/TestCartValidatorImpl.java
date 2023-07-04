package gr.evansp.setup.order.impl.rules;

import gr.evansp.exceptions.DataException;
import gr.evansp.exceptions.LogicException;
import gr.evansp.exceptions.RuleException;
import gr.evansp.factory.Factory;
import gr.evansp.setup.order.def.models.Cart;
import gr.evansp.setup.order.def.models.CartItem;
import gr.evansp.setup.order.def.rules.CartItemValidator;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;

/**
 * Tests for {@link CartValidatorImpl}.
 */
public class TestCartValidatorImpl {
  private CartValidatorImpl sut;

  @Before
  public void setUp() {
    sut = Factory.create(CartValidatorImpl.class);
    sut.input = Factory.create(Cart.class);
    sut.validator = mock(CartItemValidator.class);

    sut.input.setCartId(1L);
    sut.input.setCartItems(Set.of(mock(CartItem.class)));
  }

  /**
   * Tests for {@link CartValidatorImpl#getInput()}
   */
  @Test
  public void testGetInput() {
    Cart item = mock(Cart.class);
    sut.setInput(item);
    assertSame(item, sut.getInput());
  }

  /**
   * Tests for {@link CartValidatorImpl#getInput()}
   */
  @Test(expected = RuleException.class)
  public void testApply_noCartId() throws DataException, LogicException, RuleException {
    sut.input.setCartId(null);
    sut.apply();
  }

  /**
   * Tests for {@link CartValidatorImpl#getInput()}
   */
  @Test
  public void testApply_ok() throws DataException, LogicException, RuleException {
    sut.apply();
  }

}