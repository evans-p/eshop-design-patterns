package gr.evansp.setup.product.impl.rules;

import gr.evansp.exceptions.DataException;
import gr.evansp.exceptions.LogicException;
import gr.evansp.exceptions.RuleException;
import gr.evansp.factory.Factory;
import gr.evansp.setup.product.def.models.Characteristic;
import gr.evansp.setup.product.def.models.Product;
import gr.evansp.setup.product.def.rules.ProductValidator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Set;

/**
 * Test class {@link ProductValidator}
 */
public class TestProductValidatorImpl {
  private Product product;
  private ProductValidatorImpl sut;

  @Before
  public void setup() {
    product = Mockito.mock(Product.class);
    Characteristic characteristic = Mockito.mock(Characteristic.class);
    sut = Factory.create(ProductValidatorImpl.class);

    Mockito.when(product.getProductId()).thenReturn(10L);
    Mockito.when(product.getCategoryId()).thenReturn(10L);
    Mockito.when(product.getSKU()).thenReturn("SKU");
    Mockito.when(product.getName()).thenReturn("name");
    Mockito.when(product.getInventoryCount()).thenReturn(10);
    Mockito.when(product.getInventoryLimit()).thenReturn(10);
    Mockito.when(product.getCharacteristics()).thenReturn(Set.of(characteristic));
    Mockito.when(product.getPrice()).thenReturn(new BigDecimal(100));
    Mockito.when(product.getDescription()).thenReturn("123");
    Mockito.when(product.getDateAdded()).thenReturn(Calendar.getInstance().getTime());
    Mockito.when(product.getDateLastModified()).thenReturn(Calendar.getInstance().getTime());

    Mockito.when(characteristic.getCharacteristicId()).thenReturn(10L);
    Mockito.when(characteristic.getProductId()).thenReturn(10L);
    Mockito.when(characteristic.getCategoryId()).thenReturn(10L);
    Mockito.when(characteristic.getName()).thenReturn("Characteristic1");
    Mockito.when(characteristic.getValue()).thenReturn("value");
  }

  @Test
  public void testGetInput() {
    sut.setInput(product);
    Assert.assertEquals(product, sut.getInput());
  }

  @Test
  public void testApply_ok() throws RuleException, LogicException, DataException {
    sut.setInput(product);
    sut.apply();
  }

  @Test(expected = RuleException.class)
  public void testValidateProductId_null() throws RuleException, DataException, LogicException {
    Mockito.when(product.getProductId()).thenReturn(null);
    sut.setInput(product);
    sut.apply();
  }

  @Test(expected = RuleException.class)
  public void testValidateCategoryId_null() throws RuleException, DataException, LogicException {
    Mockito.when(product.getCategoryId()).thenReturn(null);
    sut.setInput(product);
    sut.apply();
  }

  @Test(expected = RuleException.class)
  public void testValidateSKU_null() throws RuleException, DataException, LogicException {
    Mockito.when(product.getSKU()).thenReturn(null);
    sut.setInput(product);
    sut.apply();
  }

  @Test(expected = RuleException.class)
  public void testValidateSKU_empty() throws RuleException, DataException, LogicException {
    Mockito.when(product.getSKU()).thenReturn("");
    sut.setInput(product);
    sut.apply();
  }

  @Test(expected = RuleException.class)
  public void testValidateName_null() throws RuleException, DataException, LogicException {
    Mockito.when(product.getName()).thenReturn(null);
    sut.setInput(product);
    sut.apply();
  }

  @Test(expected = RuleException.class)
  public void testValidateName_empty() throws RuleException, DataException, LogicException {
    Mockito.when(product.getName()).thenReturn("");
    sut.setInput(product);
    sut.apply();
  }

  @Test(expected = RuleException.class)
  public void testValidateInventoryLimit_null() throws RuleException, DataException, LogicException {
    Mockito.when(product.getInventoryLimit()).thenReturn(null);
    sut.setInput(product);
    sut.apply();
  }

  @Test(expected = RuleException.class)
  public void testValidateInventoryLimit_negative() throws RuleException, DataException, LogicException {
    Mockito.when(product.getInventoryLimit()).thenReturn(-1);
    sut.setInput(product);
    sut.apply();
  }

  @Test(expected = RuleException.class)
  public void testValidateInventoryCount_null() throws RuleException, DataException, LogicException {
    Mockito.when(product.getInventoryCount()).thenReturn(null);
    sut.setInput(product);
    sut.apply();
  }

  @Test(expected = RuleException.class)
  public void testValidateInventoryCount_negative() throws RuleException, DataException, LogicException {
    Mockito.when(product.getInventoryCount()).thenReturn(-1);
    sut.setInput(product);
    sut.apply();
  }

  @Test(expected = RuleException.class)
  public void testValidateInventoryCount_smallerThanInventoryLimit() throws RuleException, DataException, LogicException {
    Mockito.when(product.getInventoryCount()).thenReturn(10);
    Mockito.when(product.getInventoryLimit()).thenReturn(5);
    sut.setInput(product);
    sut.apply();
  }

  @Test(expected = RuleException.class)
  public void testValidatePrice_null() throws RuleException, DataException, LogicException {
    Mockito.when(product.getPrice()).thenReturn(null);
    sut.setInput(product);
    sut.apply();
  }

  @Test(expected = RuleException.class)
  public void testValidatePrice_negative() throws RuleException, DataException, LogicException {
    Mockito.when(product.getPrice()).thenReturn(new BigDecimal(-1));
    sut.setInput(product);
    sut.apply();
  }

  @Test(expected = RuleException.class)
  public void testValidatePrice_zero() throws RuleException, DataException, LogicException {
    Mockito.when(product.getPrice()).thenReturn(BigDecimal.ZERO);
    sut.setInput(product);
    sut.apply();
  }

  @Test(expected = RuleException.class)
  public void testValidateDateAdded_null() throws RuleException, DataException, LogicException {
    Mockito.when(product.getDateAdded()).thenReturn(null);
    sut.setInput(product);
    sut.apply();
  }

  @Test(expected = RuleException.class)
  public void testValidateCharacteristics_null() throws RuleException, DataException, LogicException {

    Mockito.when(product.getCharacteristics()).thenReturn(null);
    sut.setInput(product);
    sut.apply();
  }

  @Test(expected = RuleException.class)
  public void testValidateDateLastModified_smallerThanDateAdded() throws RuleException, DataException, LogicException, ParseException {

    Mockito.when(product.getDateAdded()).thenReturn(new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2021"));
    Mockito.when(product.getDateLastModified()).thenReturn(new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2020"));
    sut.setInput(product);
    sut.apply();
  }

  @Test
  public void testValidateDateLastModified_null() throws RuleException, DataException, LogicException {
    Mockito.when(product.getDateLastModified()).thenReturn(null);
    sut.setInput(product);
    sut.apply();
  }
}
