package gr.evansp.setup.product.def.rules;

import gr.evansp.exceptions.DataException;
import gr.evansp.exceptions.LogicException;
import gr.evansp.exceptions.RuleException;
import gr.evansp.factory.Factory;
import gr.evansp.setup.product.def.models.Characteristic;
import gr.evansp.setup.product.def.models.Product;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Test class for {@link CharacteristicValidator}
 */
public class TestCharacteristicValidator {
  private Characteristic characteristic;
  private Product product;
  private CharacteristicValidator sut = Factory.create(CharacteristicValidator.class);

  @Before
  public void setup() {
    product = Mockito.mock(Product.class);
    characteristic = Mockito.mock(Characteristic.class);

    Mockito.when(characteristic.getCharacteristicId()).thenReturn(10L);
    Mockito.when(characteristic.getProduct()).thenReturn(product);
    Mockito.when(characteristic.getName()).thenReturn("Characteristic1");
    Mockito.when(characteristic.getValue()).thenReturn("value");
  }

  @Test
  public void testApply_ok() throws RuleException, DataException, LogicException {
    sut.setInput(characteristic);
    sut.apply();
  }

  @Test(expected = RuleException.class)
  public void testValidateCharacteristicId_null() throws RuleException, DataException, LogicException {
    Mockito.when(characteristic.getCharacteristicId()).thenReturn(null);
    sut.setInput(characteristic);
    sut.apply();
  }

  @Test(expected = RuleException.class)
  public void testValidateName_null() throws RuleException, DataException, LogicException {
    Mockito.when(characteristic.getName()).thenReturn(null);
    sut.setInput(characteristic);
    sut.apply();
  }

  @Test(expected = RuleException.class)
  public void testValidateName_empty() throws RuleException, DataException, LogicException {
    Mockito.when(characteristic.getName()).thenReturn("");
    sut.setInput(characteristic);
    sut.apply();
  }

  @Test(expected = RuleException.class)
  public void testValidateValue_null() throws RuleException, DataException, LogicException {
    Mockito.when(characteristic.getValue()).thenReturn(null);
    sut.setInput(characteristic);
    sut.apply();
  }

  @Test(expected = RuleException.class)
  public void testValidateValue_empty() throws RuleException, DataException, LogicException {
    Mockito.when(characteristic.getValue()).thenReturn("");
    sut.setInput(characteristic);
    sut.apply();
  }

  @Test(expected = RuleException.class)
  public void testValidateProduct_empty() throws RuleException, DataException, LogicException {
    Mockito.when(characteristic.getProduct()).thenReturn(null);
    sut.setInput(characteristic);
    sut.apply();
  }
}
