package gr.evansp.setup.user.impl.operations;

import gr.evansp.common.DAO;
import gr.evansp.exceptions.DataException;
import gr.evansp.exceptions.LogicException;
import gr.evansp.exceptions.RuleException;
import gr.evansp.factory.Factory;
import gr.evansp.setup.user.def.models.Address;
import gr.evansp.setup.user.def.models.UserProfile;
import gr.evansp.setup.user.def.questions.NextAddressIdQuestion;
import gr.evansp.setup.user.def.rules.AddressValidator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

/**
 * Tests for {@link SaveAddressOperationImpl}
 */
public class TestSaveAddressOperationImpl {
  SaveAddressOperationImpl sut;
  UserProfile userProfile;

  @Before
  public void setup() {
    sut = Factory.create(SaveAddressOperationImpl.class);

    userProfile = Mockito.mock(UserProfile.class);
    sut.validator = Mockito.mock(AddressValidator.class);
    sut.question = Mockito.mock(NextAddressIdQuestion.class);
    sut.dao = Mockito.mock(DAO.class);
    sut.setInput(Mockito.mock(Address.class));
    sut.input.setUserProfile(userProfile);
  }

  @Test(expected = LogicException.class)
  public void testExecute_nullInput() throws DataException, LogicException, RuleException {
    sut.setInput(null);
    sut.execute();
  }

  @Test
  public void testExecute_new() throws DataException, LogicException, RuleException {
    when(sut.getInput().getAddressId()).thenReturn(null);
    when(sut.question.answer()).thenReturn(1L);
    doNothing().when(sut.validator).apply();
    doNothing().when(sut.input).setAddressId(isA(Long.class));
    when(sut.input.getUserProfile()).thenReturn(userProfile);
    doNothing().when(userProfile).setUserId(isA(Long.class));
    doNothing().when(sut.dao).save(isA(Address.class));
    sut.execute();
  }

  @Test
  public void testExecute_update() throws DataException, LogicException, RuleException {
    when(sut.getInput().getAddressId()).thenReturn(1L);
    doNothing().when(sut.validator).apply();
    doNothing().when(sut.question).ask();
    doNothing().when(sut.dao).update(isA(Address.class));

    sut.execute();
  }

  @Test
  public void testGetInput() {
    Address address = Mockito.mock(Address.class);
    sut.setInput(address);
    Assert.assertEquals(sut.getInput(), address);
  }
}