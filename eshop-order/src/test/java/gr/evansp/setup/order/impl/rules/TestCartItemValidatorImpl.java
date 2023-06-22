package gr.evansp.setup.order.impl.rules;

import gr.evansp.exceptions.RuleException;
import gr.evansp.factory.Factory;
import gr.evansp.setup.order.def.models.CartItem;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;

/**
 * Tests for {@link CartItemValidatorImpl}.
 */
public class TestCartItemValidatorImpl {
  private CartItemValidatorImpl sut;

  @Before
  public void setUp() {
    sut = Factory.create(CartItemValidatorImpl.class);
    sut.input = Factory.create(CartItem.class);

    sut.input.setCartId(1L);
    sut.input.setCategoryId(1L);
    sut.input.setProductId(1L);
    sut.input.setCount(1L);
  }

  /**
   * Tests for {@link CartItemValidatorImpl#getInput()}
   */
  @Test
  public void testGetInput() {
    CartItem item = mock(CartItem.class);
    sut.setInput(item);
    assertSame(item, sut.getInput());
  }

  /**
   * Tests for {@link CartItemValidatorImpl#apply()}
   * no categoryId.
   */
  @Test(expected = RuleException.class)
  public void testApply_noCategoryId() throws RuleException {
    sut.input.setCategoryId(null);
    sut.apply();
  }

  /**
   * Tests for {@link CartItemValidatorImpl#apply()}
   * no cart.
   */
  @Test(expected = RuleException.class)
  public void testApply_noCartId() throws RuleException {
    sut.input.setCartId(null);
    sut.apply();
  }

  /**
   * Tests for {@link CartItemValidatorImpl#apply()}
   * no productId.
   */
  @Test(expected = RuleException.class)
  public void testApply_noProductId() throws RuleException {
    sut.input.setProductId(null);
    sut.apply();
  }

  /**
   * Tests for {@link CartItemValidatorImpl#apply()}
   * null Count.
   */
  @Test(expected = RuleException.class)
  public void testApply_nullCount() throws RuleException {
    sut.input.setCount(null);
    sut.apply();
  }

  /**
   * Tests for {@link CartItemValidatorImpl#apply()}
   * zero Count.
   */
  @Test(expected = RuleException.class)
  public void testApply_zeroCount() throws RuleException {
    sut.input.setCount(0L);
    sut.apply();
  }

  /**
   * Tests for {@link CartItemValidatorImpl#apply()}
   * negative Count.
   */
  @Test(expected = RuleException.class)
  public void testApply_negativeCount() throws RuleException {
    sut.input.setCount(-1L);
    sut.apply();
  }

  /**
   * Tests for {@link CartItemValidatorImpl#apply()}
   * negative Count.
   */
  @Test
  public void testApply_ok() throws RuleException {
    sut.apply();
  }
}