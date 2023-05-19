package gr.evansp.setup.product.def.rules;

import gr.evansp.exceptions.DataException;
import gr.evansp.exceptions.LogicException;
import gr.evansp.exceptions.RuleException;
import gr.evansp.factory.Factory;
import gr.evansp.setup.product.def.models.Category;
import gr.evansp.setup.product.def.models.Characteristic;
import gr.evansp.setup.product.def.models.Product;
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
public class TestProductValidator {
  private Product product;
  private Category category;
  private Characteristic characteristic;
  private ProductValidator sut;

  @Before
  public void setup() {
    product = Mockito.mock(Product.class);
    category = Mockito.mock(Category.class);
    characteristic = Mockito.mock(Characteristic.class);
    sut = Factory.create(ProductValidator.class);

    Mockito.when(product.getProductId()).thenReturn(10L);
    Mockito.when(product.getSKU()).thenReturn("SKU");
    Mockito.when(product.getName()).thenReturn("name");
    Mockito.when(product.getInventoryCount()).thenReturn(10);
    Mockito.when(product.getInventoryLimit()).thenReturn(10);
    Mockito.when(product.getCategory()).thenReturn(category);
    Mockito.when(product.getCharacteristics()).thenReturn(Set.of(characteristic));
    Mockito.when(product.getPrice()).thenReturn(new BigDecimal(100));
    Mockito.when(product.getDescription()).thenReturn("123");
    Mockito.when(product.getDateAdded()).thenReturn(Calendar.getInstance().getTime());
    Mockito.when(product.getDateLastModified()).thenReturn(Calendar.getInstance().getTime());

    Mockito.when(characteristic.getCharacteristicId()).thenReturn(10L);
    Mockito.when(characteristic.getProduct()).thenReturn(product);
    Mockito.when(characteristic.getName()).thenReturn("Characteristic1");
    Mockito.when(characteristic.getValue()).thenReturn("value");
  }

  @Test
  public void testApply_ok() throws RuleException, DataException, LogicException {
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
  public void testValidateCategory_null() throws RuleException, DataException, LogicException {
    Mockito.when(product.getCategory()).thenReturn(null);
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
  public void testValidateDateAdded_null() throws RuleException, DataException, LogicException {
    Mockito.when(product.getDateAdded()).thenReturn(null);
    sut.setInput(product);
    sut.apply();
  }

  @Test(expected = RuleException.class)
  public void testValidateDateLastModified_smallerThanDateAdded() throws RuleException, ParseException, DataException, LogicException {

    Mockito.when(product.getDateAdded()).thenReturn(new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2021"));
    Mockito.when(product.getDateLastModified()).thenReturn(new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2020"));
    sut.setInput(product);
    sut.apply();
  }
}
