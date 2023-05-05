package gr.evansp.setup.user.def.rules;

import gr.evansp.exceptions.RuleException;
import gr.evansp.factory.Factory;
import gr.evansp.setup.user.def.models.Address;
import gr.evansp.setup.user.def.models.UserProfile;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Test class for {@link AddressValidator}
 */
public class TestAddressValidator {
  private Address address;
  private UserProfile userProfile;
  private AddressValidator sut = Factory.create(AddressValidator.class);

  @Before
  public void setup() {
    address = Mockito.mock(Address.class);
    userProfile = Mockito.mock(UserProfile.class);

    Mockito.when(address.getCity()).thenReturn("example");
    Mockito.when(address.getCountry()).thenReturn("example");
    Mockito.when(address.getStreetNumber()).thenReturn("123");
    Mockito.when(address.getStreetName()).thenReturn("example");
    Mockito.when(address.getPostalCode()).thenReturn("123");
    Mockito.when(address.getUserProfile()).thenReturn(userProfile);
    Mockito.when(address.getAddressId()).thenReturn(100l);
  }

  @After
  public void cleanup() {
    address = null;
  }

  @Test
  public void testApply_ok() throws RuleException {
    sut.setInput(address);
    sut.apply();
  }


  @Test(expected = RuleException.class)
  public void testValidateAddressId_null() throws RuleException {
    Mockito.when(address.getAddressId()).thenReturn(null);

    sut.setInput(address);
    sut.apply();
  }

  @Test(expected = RuleException.class)
  public void testValidateCity_null() throws RuleException {
    Mockito.when(address.getCity()).thenReturn(null);

    sut.setInput(address);
    sut.apply();
  }

  @Test(expected = RuleException.class)
  public void testValidateCity_containsNumbers() throws RuleException {
    Mockito.when(address.getCity()).thenReturn("A123");

    sut.setInput(address);
    sut.apply();
  }

  @Test(expected = RuleException.class)
  public void testValidateCountry_null() throws RuleException {
    Mockito.when(address.getCountry()).thenReturn(null);

    sut.setInput(address);
    sut.apply();
  }

  @Test(expected = RuleException.class)
  public void testValidateCountry_containsNumbers() throws RuleException {
    Mockito.when(address.getCountry()).thenReturn("A123");

    sut.setInput(address);
    sut.apply();
  }

  @Test(expected = RuleException.class)
  public void testValidateStreetName_null() throws RuleException {
    Mockito.when(address.getStreetName()).thenReturn(null);

    sut.setInput(address);
    sut.apply();
  }

  @Test(expected = RuleException.class)
  public void testValidateStreetName_containsNumbers() throws RuleException {
    Mockito.when(address.getStreetName()).thenReturn("A123");

    sut.setInput(address);
    sut.apply();
  }

  @Test(expected = RuleException.class)
  public void testValidateStreetNumber_null() throws RuleException {
    Mockito.when(address.getStreetNumber()).thenReturn(null);

    sut.setInput(address);
    sut.apply();
  }

  @Test(expected = RuleException.class)
  public void testValidateStreetNumber_containsLetters() throws RuleException {
    Mockito.when(address.getStreetNumber()).thenReturn("A123");

    sut.setInput(address);
    sut.apply();
  }

  @Test(expected = RuleException.class)
  public void testValidatePostalCode_null() throws RuleException {
    Mockito.when(address.getPostalCode()).thenReturn(null);

    sut.setInput(address);
    sut.apply();
  }

  @Test(expected = RuleException.class)
  public void testValidatePostalCode_containsLetters() throws RuleException {
    Mockito.when(address.getPostalCode()).thenReturn("A123");

    sut.setInput(address);
    sut.apply();
  }

  @Test(expected = RuleException.class)
  public void testValidateUserProfile_null() throws RuleException {
    Mockito.when(address.getUserProfile()).thenReturn(null);

    sut.setInput(address);
    sut.apply();
  }
}
