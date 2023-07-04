package gr.evansp.setup.order.impl.rules;

import gr.evansp.constants.StringConstants;
import gr.evansp.exceptions.DataException;
import gr.evansp.exceptions.LogicException;
import gr.evansp.exceptions.RuleException;
import gr.evansp.factory.Factory;
import gr.evansp.setup.order.def.models.Order;
import gr.evansp.setup.order.def.models.OrderItem;
import gr.evansp.setup.order.def.rules.OrderItemValidator;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;

/**
 * Tests for {@link OrderValidatorImpl}.
 */
public class TestOrderValidatorImpl {
  OrderValidatorImpl sut;

  @Before
  public void setUp() {
    sut = Factory.create(OrderValidatorImpl.class);
    sut.input = Factory.create(Order.class);
    sut.validator = mock(OrderItemValidator.class);

    sut.input.setOrderId(1L);
    sut.input.setUserId(1L);
    sut.input.setStreetName("strName");
    sut.input.setStreetNumber("123");
    sut.input.setPostalCode("12312");
    sut.input.setCity("city");
    sut.input.setCountry("Country");
    sut.input.setOrderItems(Set.of(mock(OrderItem.class)));
  }

  /**
   * Tests for {@link OrderValidatorImpl#getInput()}
   */
  @Test
  public void testGetInput() {
    Order item = mock(Order.class);
    sut.setInput(item);
    assertSame(item, sut.getInput());
  }

  /**
   * Tests for {@link OrderValidatorImpl#apply()} OK.
   */
  @Test
  public void testApply_ok() throws DataException, LogicException, RuleException {
    sut.apply();
  }

  /**
   * Tests for {@link OrderValidatorImpl#apply()} no orderItem.
   */
  @Test(expected = RuleException.class)
  public void testApply_noOrderItems() throws DataException, LogicException, RuleException {
    sut.input.setOrderItems(null);
    sut.apply();
  }

  /**
   * Tests for {@link OrderValidatorImpl#apply()} no orderItem.
   */
  @Test(expected = RuleException.class)
  public void testApply_EmptyoOrderItems() throws DataException, LogicException, RuleException {
    sut.input.setOrderItems(new HashSet<>());
    sut.apply();
  }

  /**
   * Tests for {@link OrderValidatorImpl#apply()} null street name.
   */
  @Test(expected = RuleException.class)
  public void testApply_nullStreetName() throws DataException, LogicException, RuleException {
    sut.input.setStreetName(null);
    sut.apply();
  }

  /**
   * Tests for {@link OrderValidatorImpl#apply()} empty street name.
   */
  @Test(expected = RuleException.class)
  public void testApply_emptyStreetName() throws DataException, LogicException, RuleException {
    sut.input.setStreetName(StringConstants.EMPTY);
    sut.apply();
  }

  /**
   * Tests for {@link OrderValidatorImpl#apply()} empty street name.
   */
  @Test(expected = RuleException.class)
  public void testApply_streetNameContainsNumbers() throws DataException, LogicException, RuleException {
    sut.input.setStreetName("123StringConstantsEMPTY");
    sut.apply();
  }


  /**
   * Tests for {@link OrderValidatorImpl#apply()} null street Number.
   */
  @Test(expected = RuleException.class)
  public void testApply_nullStreetNumber() throws DataException, LogicException, RuleException {
    sut.input.setStreetNumber(null);
    sut.apply();
  }

  /**
   * Tests for {@link OrderValidatorImpl#apply()} empty street Number.
   */
  @Test(expected = RuleException.class)
  public void testApply_emptyStreetNumber() throws DataException, LogicException, RuleException {
    sut.input.setStreetNumber(StringConstants.EMPTY);
    sut.apply();
  }

  /**
   * Tests for {@link OrderValidatorImpl#apply()} empty street
   * Number Contains Letters.
   */
  @Test(expected = RuleException.class)
  public void testApply_streetNumberContainsLetters() throws DataException, LogicException, RuleException {
    sut.input.setStreetNumber("123StringConstantsEMPTY");
    sut.apply();
  }


  /**
   * Tests for {@link OrderValidatorImpl#apply()} null PostalCode.
   */
  @Test(expected = RuleException.class)
  public void testApply_nullPostalCode() throws DataException, LogicException, RuleException {
    sut.input.setPostalCode(null);
    sut.apply();
  }

  /**
   * Tests for {@link OrderValidatorImpl#apply()} empty street Number.
   */
  @Test(expected = RuleException.class)
  public void testApply_emptyPostalCode() throws DataException, LogicException, RuleException {
    sut.input.setPostalCode(StringConstants.EMPTY);
    sut.apply();
  }

  /**
   * Tests for {@link OrderValidatorImpl#apply()} PostalCode
   * Contains Letters.
   */
  @Test(expected = RuleException.class)
  public void testApply_PostalCodeContainsLetters() throws DataException, LogicException, RuleException {
    sut.input.setPostalCode("123StringConstantsEMPTY");
    sut.apply();
  }

  /**
   * Tests for {@link OrderValidatorImpl#apply()} null City.
   */
  @Test(expected = RuleException.class)
  public void testApply_nullCity() throws DataException, LogicException, RuleException {
    sut.input.setCity(null);
    sut.apply();
  }

  /**
   * Tests for {@link OrderValidatorImpl#apply()} empty City.
   */
  @Test(expected = RuleException.class)
  public void testApply_emptyCity() throws DataException, LogicException, RuleException {
    sut.input.setCity(StringConstants.EMPTY);
    sut.apply();
  }

  /**
   * Tests for {@link OrderValidatorImpl#apply()} PostalCode
   * Contains Letters.
   */
  @Test(expected = RuleException.class)
  public void testApply_CityContainsNumbers() throws DataException, LogicException, RuleException {
    sut.input.setCity("123StringConstantsEMPTY");
    sut.apply();
  }


  /**
   * Tests for {@link OrderValidatorImpl#apply()} null City.
   */
  @Test(expected = RuleException.class)
  public void testApply_nullCountry() throws DataException, LogicException, RuleException {
    sut.input.setCountry(null);
    sut.apply();
  }

  /**
   * Tests for {@link OrderValidatorImpl#apply()} empty City.
   */
  @Test(expected = RuleException.class)
  public void testApply_emptyCountry() throws DataException, LogicException, RuleException {
    sut.input.setCountry(StringConstants.EMPTY);
    sut.apply();
  }

  /**
   * Tests for {@link OrderValidatorImpl#apply()} PostalCode
   * Contains Letters.
   */
  @Test(expected = RuleException.class)
  public void testApply_CountryContainsNumbers() throws DataException, LogicException, RuleException {
    sut.input.setCountry("123StringConstantsEMPTY");
    sut.apply();
  }
}