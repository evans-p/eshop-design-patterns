package gr.evansp.setup.user.impl.operations;

import gr.evansp.common.DAO;
import gr.evansp.exceptions.DataException;
import gr.evansp.exceptions.LogicException;
import gr.evansp.exceptions.RuleException;
import gr.evansp.factory.Factory;
import gr.evansp.setup.user.def.models.User;
import gr.evansp.setup.user.def.models.UserProfile;
import gr.evansp.setup.user.def.questions.NextUserIdQuestion;
import gr.evansp.setup.user.def.questions.UserIdExistsQuestion;
import gr.evansp.setup.user.def.rules.UserValidator;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

public class TestSaveUserOperationImpl {
  SaveUserOperationImpl sut;
  UserProfile userProfile;

  @Before
  public void setup() {
    sut = Factory.create(SaveUserOperationImpl.class);

    userProfile = Mockito.mock(UserProfile.class);
    sut.validator = Mockito.mock(UserValidator.class);
    sut.idExistsQuestion = Mockito.mock(UserIdExistsQuestion.class);
    sut.nextUserIdQuestion = Mockito.mock(NextUserIdQuestion.class);
    sut.dao = Mockito.mock(DAO.class);
    sut.setInput(Mockito.mock(User.class));
    sut.input.setUserProfile(userProfile);
  }

  @Test(expected = LogicException.class)
  public void testExecute_nullInput() throws DataException, LogicException, RuleException {
    sut.setInput(null);
    sut.execute();
  }

  @Test
  public void testExecute_nullUserId() throws DataException, LogicException, RuleException {
    when(sut.getInput().getUserId()).thenReturn(null);
    when(sut.nextUserIdQuestion.answer()).thenReturn(1L);
    doNothing().when(sut.validator).apply();
    doNothing().when(sut.input).setUserId(isA(Long.class));
    when(sut.input.getUserProfile()).thenReturn(userProfile);
    doNothing().when(userProfile).setUserId(isA(Long.class));
    doNothing().when(sut.dao).save(isA(User.class));
    sut.execute();
  }

  @Test
  public void testExecute_idDoesNotExist() throws DataException, LogicException, RuleException {
    when(sut.getInput().getUserId()).thenReturn(1L);
    doNothing().when(sut.validator).apply();
    doNothing().when(sut.idExistsQuestion).ask();
    when(sut.idExistsQuestion.answer()).thenReturn(false);
    doNothing().when(sut.dao).save(isA(User.class));

    sut.execute();
  }

  @Test
  public void testExecute_idExists() throws DataException, LogicException, RuleException {
    when(sut.getInput().getUserId()).thenReturn(1L);
    doNothing().when(sut.validator).apply();
    doNothing().when(sut.idExistsQuestion).ask();
    when(sut.idExistsQuestion.answer()).thenReturn(true);
    doNothing().when(sut.dao).update(isA(User.class));

    sut.execute();
  }
}
