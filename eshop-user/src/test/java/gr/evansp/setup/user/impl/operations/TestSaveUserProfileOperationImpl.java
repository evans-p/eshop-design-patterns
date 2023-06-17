package gr.evansp.setup.user.impl.operations;

import gr.evansp.exceptions.DataException;
import gr.evansp.exceptions.LogicException;
import gr.evansp.exceptions.RuleException;
import gr.evansp.setup.user.def.models.UserProfile;
import gr.evansp.setup.user.def.persistence.UserProfileRepository;
import gr.evansp.setup.user.def.rules.UserProfileValidator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

/**
 * Tests for {@link SaveUserProfileOperationImpl}
 */
public class TestSaveUserProfileOperationImpl {
  SaveUserProfileOperationImpl sut;
  UserProfile userProfile;

  @Before
  public void setup() {
    sut = new SaveUserProfileOperationImpl();
    sut.validator = mock(UserProfileValidator.class);
    sut.repository = mock(UserProfileRepository.class);
    userProfile = mock(UserProfile.class);
    sut.setInput(userProfile);
  }

  @Test(expected = LogicException.class)
  public void testExecute_nullInput() throws DataException, LogicException, RuleException {
    sut.setInput(null);
    sut.execute();
  }

  @Test
  public void testExecute_ok() throws DataException, LogicException, RuleException {
    doNothing().when(sut.validator).apply();
    doNothing().when(sut.repository).update(isA(UserProfile.class));
    sut.execute();

    verify(sut.validator, times(1)).setInput(isA(UserProfile.class));
    verify(sut.validator, times(1)).apply();
    verify(sut.repository, times(1)).update(isA(UserProfile.class));
  }

  @Test
  public void testGetInput() {
    sut.setInput(userProfile);
    Assert.assertEquals(sut.getInput(), userProfile);
  }
}
