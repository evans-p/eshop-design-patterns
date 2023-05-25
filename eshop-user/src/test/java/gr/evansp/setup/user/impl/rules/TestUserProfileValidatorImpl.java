package gr.evansp.setup.user.impl.rules;

import gr.evansp.exceptions.DataException;
import gr.evansp.exceptions.LogicException;
import gr.evansp.exceptions.RuleException;
import gr.evansp.factory.Factory;
import gr.evansp.setup.user.def.models.UserProfile;
import gr.evansp.setup.user.def.rules.UserProfileValidator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;

/**
 * Test class for {@link UserProfileValidator}
 */
public class TestUserProfileValidatorImpl {
  UserProfile userProfile;
  UserProfileValidator sut = Factory.create(UserProfileValidator.class);

  @Before
  public void setup() {
    userProfile = Mockito.mock(UserProfile.class);


    Mockito.when(userProfile.getUserId()).thenReturn(1L);
    Mockito.when(userProfile.getFirstName()).thenReturn("First");
    Mockito.when(userProfile.getLastName()).thenReturn("Last");
    Mockito.when(userProfile.getPhoneNo()).thenReturn("0123456789");
    Mockito.when(userProfile.getDateAdded()).thenReturn(Calendar.getInstance().getTime());
    Mockito.when(userProfile.getDateLastModified()).thenReturn(Calendar.getInstance().getTime());
    Mockito.when(userProfile.getAddresses()).thenReturn(Collections.emptySet());
  }

  @After
  public void cleanup() {
    userProfile = null;
  }

  @Test
  public void testGetInput() {
    sut.setInput(userProfile);
    Assert.assertEquals(userProfile, sut.getInput());
  }

  @Test
  public void testApply_ok() throws RuleException, DataException, LogicException {
    sut.setInput(userProfile);
    sut.apply();
  }

  @Test(expected = RuleException.class)
  public void testValidateUserId_null() throws RuleException, DataException, LogicException {
    Mockito.when(userProfile.getUserId()).thenReturn(null);
    sut.setInput(userProfile);
    sut.apply();
  }

  @Test(expected = RuleException.class)
  public void testValidateFirstName_null() throws RuleException, DataException, LogicException {
    Mockito.when(userProfile.getFirstName()).thenReturn(null);
    sut.setInput(userProfile);
    sut.apply();
  }

  @Test(expected = RuleException.class)
  public void testValidateFirstName_empty() throws RuleException, DataException, LogicException {
    Mockito.when(userProfile.getFirstName()).thenReturn("");
    sut.setInput(userProfile);
    sut.apply();
  }

  @Test(expected = RuleException.class)
  public void testValidateLastName_null() throws RuleException, DataException, LogicException {
    Mockito.when(userProfile.getLastName()).thenReturn(null);
    sut.setInput(userProfile);
    sut.apply();
  }

  @Test(expected = RuleException.class)
  public void testValidateLastName_empty() throws RuleException, DataException, LogicException {
    Mockito.when(userProfile.getLastName()).thenReturn("");
    sut.setInput(userProfile);
    sut.apply();
  }

  @Test(expected = RuleException.class)
  public void testValidatePhoneNo_null() throws RuleException, DataException, LogicException {
    Mockito.when(userProfile.getPhoneNo()).thenReturn(null);
    sut.setInput(userProfile);
    sut.apply();
  }

  @Test(expected = RuleException.class)
  public void testValidatePhoneNo_containsLetters() throws RuleException, DataException, LogicException {
    Mockito.when(userProfile.getPhoneNo()).thenReturn("null123");
    sut.setInput(userProfile);
    sut.apply();
  }

  @Test(expected = RuleException.class)
  public void testValidatePhoneNo_invalidLength() throws RuleException, DataException, LogicException {
    Mockito.when(userProfile.getPhoneNo()).thenReturn("123");
    sut.setInput(userProfile);
    sut.apply();
  }

  @Test(expected = RuleException.class)
  public void testValidateDateAdded_null() throws RuleException, DataException, LogicException {
    Mockito.when(userProfile.getDateAdded()).thenReturn(null);
    sut.setInput(userProfile);
    sut.apply();
  }

  @Test(expected = RuleException.class)
  public void testValidateDateLastModified_smallerThanDateAdded() throws RuleException, ParseException, DataException, LogicException {

    Mockito.when(userProfile.getDateAdded()).thenReturn(new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2021"));
    Mockito.when(userProfile.getDateLastModified()).thenReturn(new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2020"));
    sut.setInput(userProfile);
    sut.apply();
  }

}
