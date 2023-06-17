package gr.evansp.setup.user.impl.operations;

import gr.evansp.exceptions.DataException;
import gr.evansp.exceptions.LogicException;
import gr.evansp.exceptions.RuleException;
import gr.evansp.factory.Factory;
import gr.evansp.setup.user.def.models.User;
import gr.evansp.setup.user.def.models.UserProfile;
import gr.evansp.setup.user.def.persistence.UserRepository;
import gr.evansp.setup.user.def.questions.NextUserIdQuestion;
import gr.evansp.setup.user.def.rules.UserValidator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.*;

@SuppressWarnings("unchecked")
public class TestSaveUserOperationImpl {
  SaveUserOperationImpl sut;
  UserProfile userProfile;

  @Before
  public void setup() {
    sut = Factory.create(SaveUserOperationImpl.class);

    userProfile = Mockito.mock(UserProfile.class);
    sut.validator = Mockito.mock(UserValidator.class);
    sut.nextUserIdQuestion = Mockito.mock(NextUserIdQuestion.class);
    sut.repository = Mockito.mock(UserRepository.class);
    sut.setInput(Mockito.mock(User.class));
  }

  @After
  public void cleanup() {
    sut = null;
    userProfile = null;
  }

  @Test(expected = LogicException.class)
  public void testExecute_nullInput() throws DataException, LogicException, RuleException {
    sut.setInput(null);
    sut.execute();
  }

  @Test
  public void testExecute_new() throws DataException, LogicException, RuleException {
    when(sut.getInput().getUserId()).thenReturn(null);
    doNothing().when(sut.nextUserIdQuestion).ask();
    when(sut.nextUserIdQuestion.answer()).thenReturn(1L);
    doNothing().when(sut.input).setUserId(isA(Long.class));
    when(sut.input.getUserProfile()).thenReturn(userProfile);
    doNothing().when(userProfile).setUserId(isA(Long.class));
    doNothing().when(sut.validator).setInput(isA(User.class));
    doNothing().when(sut.validator).apply();
    doNothing().when(sut.repository).save(isA(User.class));

    sut.execute();

    verify(sut.nextUserIdQuestion, times(1)).ask();
    verify(sut.nextUserIdQuestion, times(1)).answer();
    verify(sut.input, times(1)).setUserId(isA(Long.class));
    verify(sut.validator, times(1)).apply();
    verify(sut.repository, times(1)).save(isA(User.class));
    verify(sut.repository, times(0)).update(isA(User.class));
  }

  @Test
  public void testExecute_update() throws DataException, LogicException, RuleException {
    when(sut.getInput().getUserId()).thenReturn(1L);
    doNothing().when(sut.validator).setInput(isA(User.class));
    doNothing().when(sut.validator).apply();
    doNothing().when(sut.repository).update(isA(User.class));

    sut.execute();

    verify(sut.nextUserIdQuestion, times(0)).ask();
    verify(sut.nextUserIdQuestion, times(0)).answer();
    verify(sut.input, times(0)).setUserId(isA(Long.class));
    verify(sut.validator, times(1)).apply();
    verify(sut.repository, times(0)).save(isA(User.class));
    verify(sut.repository, times(1)).update(isA(User.class));
  }
}
