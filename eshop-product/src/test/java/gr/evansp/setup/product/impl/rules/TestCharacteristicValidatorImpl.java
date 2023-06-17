package gr.evansp.setup.product.impl.rules;

import gr.evansp.exceptions.RuleException;
import gr.evansp.factory.Factory;
import gr.evansp.setup.product.def.models.Characteristic;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Test class for {@link CharacteristicValidatorImpl}
 */
@SuppressWarnings("FieldMayBeFinal")
public class TestCharacteristicValidatorImpl {
  private final CharacteristicValidatorImpl sut = Factory.create(CharacteristicValidatorImpl.class);
  private Characteristic characteristic;

  @Before
  public void setup() {
    characteristic = Mockito.mock(Characteristic.class);

    Mockito.when(characteristic.getCharacteristicId()).thenReturn(10L);
    Mockito.when(characteristic.getProductId()).thenReturn(10L);
    Mockito.when(characteristic.getCategoryId()).thenReturn(10L);
    Mockito.when(characteristic.getName()).thenReturn("Characteristic1");
    Mockito.when(characteristic.getValue()).thenReturn("value");
  }

  @Test
  public void testGetInput() {
    sut.setInput(characteristic);
    Assert.assertEquals(characteristic, sut.getInput());
  }

  @Test
  public void testApply_ok() throws RuleException {
    sut.setInput(characteristic);
    sut.apply();
  }

  @Test(expected = RuleException.class)
  public void testValidateCharacteristicId_null() throws RuleException {
    Mockito.when(characteristic.getCharacteristicId()).thenReturn(null);
    sut.setInput(characteristic);
    sut.apply();
  }

  @Test(expected = RuleException.class)
  public void testValidateProductId_null() throws RuleException {
    Mockito.when(characteristic.getProductId()).thenReturn(null);
    sut.setInput(characteristic);
    sut.apply();
  }

  @Test(expected = RuleException.class)
  public void testValidateCategoryId_null() throws RuleException {
    Mockito.when(characteristic.getCategoryId()).thenReturn(null);
    sut.setInput(characteristic);
    sut.apply();
  }

  @Test(expected = RuleException.class)
  public void testValidateName_null() throws RuleException {
    Mockito.when(characteristic.getName()).thenReturn(null);
    sut.setInput(characteristic);
    sut.apply();
  }

  @Test(expected = RuleException.class)
  public void testValidateName_empty() throws RuleException {
    Mockito.when(characteristic.getName()).thenReturn("");
    sut.setInput(characteristic);
    sut.apply();
  }

  @Test(expected = RuleException.class)
  public void testValidateValue_null() throws RuleException {
    Mockito.when(characteristic.getValue()).thenReturn(null);
    sut.setInput(characteristic);
    sut.apply();
  }

  @Test(expected = RuleException.class)
  public void testValidateValue_empty() throws RuleException {
    Mockito.when(characteristic.getValue()).thenReturn("");
    sut.setInput(characteristic);
    sut.apply();
  }
}
