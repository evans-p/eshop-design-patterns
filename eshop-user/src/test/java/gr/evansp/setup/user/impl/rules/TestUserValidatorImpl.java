package gr.evansp.setup.user.impl.rules;

import gr.evansp.exceptions.DataException;
import gr.evansp.exceptions.LogicException;
import gr.evansp.exceptions.RuleException;
import gr.evansp.factory.Factory;
import gr.evansp.setup.user.def.models.User;
import gr.evansp.setup.user.def.models.UserProfile;
import gr.evansp.setup.user.def.questions.UserEmailExistsQuestion;
import gr.evansp.setup.user.def.rules.UserProfileValidator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Calendar;
import java.util.Collections;

/**
 * Test class for {@link UserValidatorImpl}
 */
public class TestUserValidatorImpl {
  User user;
  UserProfile userProfile;
  UserProfileValidator userProfileValidator;
  UserEmailExistsQuestion question;
  UserValidatorImpl sut = Factory.create(UserValidatorImpl.class);


  @Before
  public void setup() throws DataException, LogicException {
    user = Mockito.mock(User.class);
    userProfile = Mockito.mock(UserProfile.class);
    userProfileValidator = Mockito.mock(UserProfileValidator.class);
    question = Mockito.mock(UserEmailExistsQuestion.class);

    Mockito.when(userProfile.getUserId()).thenReturn(1L);
    Mockito.when(userProfile.getFirstName()).thenReturn("First");
    Mockito.when(userProfile.getLastName()).thenReturn("Last");
    Mockito.when(userProfile.getPhoneNo()).thenReturn("0123456789");
    Mockito.when(userProfile.getDateAdded()).thenReturn(Calendar.getInstance().getTime());
    Mockito.when(userProfile.getDateLastModified()).thenReturn(Calendar.getInstance().getTime());
    Mockito.when(userProfile.getAddresses()).thenReturn(Collections.emptySet());

    Mockito.doNothing().when(question).ask();
    Mockito.when(question.answer()).thenReturn(false);

    Mockito.when(user.getUserId()).thenReturn(1L);
    Mockito.when(user.getUserProfile()).thenReturn(userProfile);
    Mockito.when(user.getEmail()).thenReturn("random@random.com");
    Mockito.when(user.getPassword()).thenReturn("12345678@asd");
  }

  @Test
  public void testGetInput() {
    sut.setInput(user);
    Assert.assertEquals(user, sut.getInput());
  }

  @Test
  public void testApply_ok() throws RuleException, DataException, LogicException {
    sut.setInput(user);
    sut.question = question;
    sut.apply();
  }

  @Test(expected = RuleException.class)
  public void testValidateUserId_null() throws RuleException, DataException, LogicException {
    Mockito.when(user.getUserId()).thenReturn(null);
    sut.setInput(user);
    sut.question = question;
    sut.apply();
  }

  @Test(expected = RuleException.class)
  public void testValidateUserProfile_null() throws RuleException, DataException, LogicException {
    Mockito.when(user.getUserProfile()).thenReturn(null);
    sut.setInput(user);
    sut.question = question;
    sut.apply();
  }

  @Test(expected = RuleException.class)
  public void testValidateEmail_null() throws RuleException, DataException, LogicException {
    Mockito.when(user.getEmail()).thenReturn(null);
    sut.setInput(user);
    sut.question = question;
    sut.apply();
  }

  @Test(expected = RuleException.class)
  public void testValidateEmail_empty() throws RuleException, DataException, LogicException {
    Mockito.when(user.getEmail()).thenReturn("");
    sut.setInput(user);
    sut.question = question;
    sut.apply();
  }

  @Test(expected = RuleException.class)
  public void testValidateEmail_noAtChar() throws RuleException, DataException, LogicException {
    Mockito.when(user.getEmail()).thenReturn("example");
    sut.setInput(user);
    sut.question = question;
    sut.apply();
  }

  @Test(expected = RuleException.class)
  public void testValidateEmail_tooManyAtChars() throws RuleException, DataException, LogicException {
    Mockito.when(user.getEmail()).thenReturn("@@example");
    sut.setInput(user);
    sut.question = question;
    sut.apply();
  }

  @Test(expected = RuleException.class)
  public void testValidateEmail_noDotChar() throws RuleException, DataException, LogicException {
    Mockito.when(user.getEmail()).thenReturn("@example");
    sut.setInput(user);
    sut.question = question;
    sut.apply();
  }

  @Test(expected = RuleException.class)
  public void testValidateEmail_tooManyDotChars() throws RuleException, DataException, LogicException {
    Mockito.when(user.getEmail()).thenReturn("@example..");
    sut.setInput(user);
    sut.question = question;
    sut.apply();
  }

  @Test(expected = RuleException.class)
  public void testValidateEmail_exists() throws RuleException, DataException, LogicException {
    Mockito.when(user.getEmail()).thenReturn("random@random.com");
    Mockito.when(question.answer()).thenReturn(true);
    sut.setInput(user);
    sut.question = question;
    sut.apply();
  }

  @Test(expected = RuleException.class)
  public void testValidatePassword_null() throws RuleException, DataException, LogicException {
    Mockito.when(user.getPassword()).thenReturn(null);
    sut.setInput(user);
    sut.question = question;
    sut.apply();
  }

  @Test(expected = RuleException.class)
  public void testValidatePassword_empty() throws RuleException, DataException, LogicException {
    Mockito.when(user.getPassword()).thenReturn("");
    sut.setInput(user);
    sut.question = question;
    sut.apply();
  }

  @Test(expected = RuleException.class)
  public void testValidatePassword_tooShort() throws RuleException, DataException, LogicException {
    Mockito.when(user.getPassword()).thenReturn("example");
    sut.setInput(user);
    sut.question = question;
    sut.apply();
  }

  @Test(expected = RuleException.class)
  public void testValidatePassword_noSymbols() throws RuleException, DataException, LogicException {
    Mockito.when(user.getPassword()).thenReturn("123123123example");
    sut.setInput(user);
    sut.question = question;
    sut.apply();
  }

  @Test(expected = RuleException.class)
  public void testValidatePassword_noLetters() throws RuleException, DataException, LogicException {
    Mockito.when(user.getPassword()).thenReturn("41351412523535@@#!@#");
    sut.setInput(user);
    sut.question = question;
    sut.apply();
  }

  @Test(expected = RuleException.class)
  public void testValidatePassword_noNumbers() throws RuleException, DataException, LogicException {
    Mockito.when(user.getPassword()).thenReturn("dsfasfgsdfasfasdf$#$$@#$#$#@");
    sut.setInput(user);
    sut.question = question;
    sut.apply();
  }
}
