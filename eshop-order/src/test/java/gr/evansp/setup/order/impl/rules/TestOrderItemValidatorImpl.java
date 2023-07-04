package gr.evansp.setup.order.impl.rules;

import gr.evansp.exceptions.RuleException;
import gr.evansp.factory.Factory;
import gr.evansp.setup.order.def.models.OrderItem;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;

/**
 * Tests for {@link OrderItemValidatorImpl}.
 */
public class TestOrderItemValidatorImpl {
  /**
   * Subject under test.
   */
  OrderItemValidatorImpl sut;

  @Before
  public void setup() {
    sut = Factory.create(OrderItemValidatorImpl.class);
    sut.input = Factory.create(OrderItem.class);
  }

  /**
   * Tests for {@link CartValidatorImpl#getInput()}
   */
  @Test
  public void testGetInput() {
    OrderItem item = mock(OrderItem.class);
    sut.setInput(item);
    assertSame(item, sut.getInput());
  }

  /**
   * test for {@link OrderItemValidatorImpl#apply()} ok.
   */
  @Test
  public void testApply_ok() throws RuleException {
    sut.input.setOrderId(1L);
    sut.input.setCategoryId(1L);
    sut.input.setUserId(1L);
    sut.input.setProductId(1L);
    sut.input.setCount(1L);
    sut.apply();
  }

  /**
   * test for {@link OrderItemValidatorImpl#apply()} nullOrderId.
   */
  @Test(expected = RuleException.class)
  public void testApply_nullOrderId() throws RuleException {
    sut.input.setOrderId(null);
    sut.input.setCategoryId(1L);
    sut.input.setUserId(1L);
    sut.input.setProductId(1L);
    sut.input.setCount(1L);
    sut.apply();
  }

  /**
   * test for {@link OrderItemValidatorImpl#apply()} null Category Id.
   */
  @Test(expected = RuleException.class)
  public void testApply_nullCategoryId() throws RuleException {
    sut.input.setOrderId(1L);
    sut.input.setCategoryId(null);
    sut.input.setUserId(1L);
    sut.input.setProductId(1L);
    sut.input.setCount(1L);
    sut.apply();
  }

  /**
   * test for {@link OrderItemValidatorImpl#apply()} null User Id.
   */
  @Test(expected = RuleException.class)
  public void testApply_nullUserId() throws RuleException {
    sut.input.setOrderId(1L);
    sut.input.setCategoryId(1L);
    sut.input.setUserId(null);
    sut.input.setProductId(1L);
    sut.input.setCount(1L);
    sut.apply();
  }

  /**
   * test for {@link OrderItemValidatorImpl#apply()} null Product Id.
   */
  @Test(expected = RuleException.class)
  public void testApply_nullProductId() throws RuleException {
    sut.input.setOrderId(1L);
    sut.input.setCategoryId(1L);
    sut.input.setUserId(1L);
    sut.input.setProductId(null);
    sut.input.setCount(1L);
    sut.apply();
  }

  /**
   * test for {@link OrderItemValidatorImpl#apply()} null count.
   */
  @Test(expected = RuleException.class)
  public void testApply_nullCount() throws RuleException {
    sut.input.setOrderId(1L);
    sut.input.setCategoryId(1L);
    sut.input.setUserId(1L);
    sut.input.setProductId(1L);
    sut.input.setCount(null);
    sut.apply();
  }

  /**
   * test for {@link OrderItemValidatorImpl#apply()} null count.
   */
  @Test(expected = RuleException.class)
  public void testApply_zeroCount() throws RuleException {
    sut.input.setOrderId(1L);
    sut.input.setCategoryId(1L);
    sut.input.setUserId(1L);
    sut.input.setProductId(1L);
    sut.input.setCount(0L);
    sut.apply();
  }

  /**
   * test for {@link OrderItemValidatorImpl#apply()} negative count.
   */
  @Test(expected = RuleException.class)
  public void testApply_negativeCount() throws RuleException {
    sut.input.setOrderId(1L);
    sut.input.setCategoryId(1L);
    sut.input.setUserId(1L);
    sut.input.setProductId(1L);
    sut.input.setCount(-1L);
    sut.apply();
  }

}