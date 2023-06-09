package gr.evansp.setup.user.impl.rules;

import gr.evansp.constants.StringConstants;
import gr.evansp.exceptions.DataException;
import gr.evansp.exceptions.LogicException;
import gr.evansp.exceptions.RuleException;
import gr.evansp.factory.Factory;
import gr.evansp.setup.user.def.models.Address;
import gr.evansp.setup.user.def.rules.AddressValidator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Test class for {@link AddressValidator}
 */
public class TestAddressValidatorImpl {
    private final AddressValidator sut = Factory.create(AddressValidator.class);
    private Address address;

    @Before
    public void setup() {
        address = Mockito.mock(Address.class);

        Mockito.when(address.getCity()).thenReturn("example");
        Mockito.when(address.getCountry()).thenReturn("example");
        Mockito.when(address.getStreetNumber()).thenReturn("123");
        Mockito.when(address.getStreetName()).thenReturn("example");
        Mockito.when(address.getPostalCode()).thenReturn("123");
        Mockito.when(address.getAddressId()).thenReturn(100L);
        Mockito.when(address.getUserId()).thenReturn(100L);
    }

    @Test
    public void testGetInput() {
        sut.setInput(address);
        Assert.assertEquals(address, sut.getInput());
    }

    @Test
    public void testApply_ok() throws RuleException, DataException, LogicException {
        sut.setInput(address);
        sut.apply();
    }


    @Test(expected = RuleException.class)
    public void testValidate_userIdNull() throws RuleException, DataException, LogicException {
        Mockito.when(address.getUserId()).thenReturn(null);
        sut.setInput(address);
        sut.apply();
    }

    @Test(expected = RuleException.class)
    public void testValidateAddressId_null() throws RuleException, DataException, LogicException {
        Mockito.when(address.getAddressId()).thenReturn(null);
        sut.setInput(address);
        sut.apply();
    }

    @Test(expected = RuleException.class)
    public void testValidateCity_null() throws RuleException, DataException, LogicException {
        Mockito.when(address.getCity()).thenReturn(null);

        sut.setInput(address);
        sut.apply();
    }

    @Test(expected = RuleException.class)
    public void testValidateCity_empty() throws RuleException, DataException, LogicException {
        Mockito.when(address.getCity()).thenReturn(StringConstants.EMPTY);

        sut.setInput(address);
        sut.apply();
    }

    @Test(expected = RuleException.class)
    public void testValidateCity_containsNumbers() throws RuleException, DataException, LogicException {
        Mockito.when(address.getCity()).thenReturn("A123");

        sut.setInput(address);
        sut.apply();
    }

    @Test(expected = RuleException.class)
    public void testValidateCountry_null() throws RuleException, DataException, LogicException {
        Mockito.when(address.getCountry()).thenReturn(null);

        sut.setInput(address);
        sut.apply();
    }

    @Test(expected = RuleException.class)
    public void testValidateCountry_empty() throws RuleException, DataException, LogicException {
        Mockito.when(address.getCountry()).thenReturn(StringConstants.EMPTY);

        sut.setInput(address);
        sut.apply();
    }

    @Test(expected = RuleException.class)
    public void testValidateCountry_containsNumbers() throws RuleException, DataException, LogicException {
        Mockito.when(address.getCountry()).thenReturn("A123");

        sut.setInput(address);
        sut.apply();
    }

    @Test(expected = RuleException.class)
    public void testValidateStreetName_null() throws RuleException, DataException, LogicException {
        Mockito.when(address.getStreetName()).thenReturn(null);

        sut.setInput(address);
        sut.apply();
    }

    @Test(expected = RuleException.class)
    public void testValidateStreetName_empty() throws RuleException, DataException, LogicException {
        Mockito.when(address.getStreetName()).thenReturn(StringConstants.EMPTY);
        sut.setInput(address);
        sut.apply();
    }

    @Test(expected = RuleException.class)
    public void testValidateStreetName_containsNumbers() throws RuleException, DataException, LogicException {
        Mockito.when(address.getStreetName()).thenReturn("A123");

        sut.setInput(address);
        sut.apply();
    }

    @Test(expected = RuleException.class)
    public void testValidateStreetNumber_null() throws RuleException, DataException, LogicException {
        Mockito.when(address.getStreetNumber()).thenReturn(null);

        sut.setInput(address);
        sut.apply();
    }

    @Test(expected = RuleException.class)
    public void testValidateStreetNumber_empty() throws RuleException, DataException, LogicException {
        Mockito.when(address.getStreetNumber()).thenReturn(StringConstants.EMPTY);
        sut.setInput(address);
        sut.apply();
    }

    @Test(expected = RuleException.class)
    public void testValidateStreetNumber_containsLetters() throws RuleException, DataException, LogicException {
        Mockito.when(address.getStreetNumber()).thenReturn("A123");

        sut.setInput(address);
        sut.apply();
    }

    @Test(expected = RuleException.class)
    public void testValidatePostalCode_null() throws RuleException, DataException, LogicException {
        Mockito.when(address.getPostalCode()).thenReturn(null);

        sut.setInput(address);
        sut.apply();
    }

    @Test(expected = RuleException.class)
    public void testValidatePostalCode_empty() throws RuleException, DataException, LogicException {
        Mockito.when(address.getPostalCode()).thenReturn(StringConstants.EMPTY);

        sut.setInput(address);
        sut.apply();
    }

    @Test(expected = RuleException.class)
    public void testValidatePostalCode_containsLetters() throws RuleException, DataException, LogicException {
        Mockito.when(address.getPostalCode()).thenReturn("A123");

        sut.setInput(address);
        sut.apply();
    }
}
