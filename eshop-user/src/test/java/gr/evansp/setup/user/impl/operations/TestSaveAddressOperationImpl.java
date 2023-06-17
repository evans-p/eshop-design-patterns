package gr.evansp.setup.user.impl.operations;

import gr.evansp.exceptions.DataException;
import gr.evansp.exceptions.LogicException;
import gr.evansp.exceptions.RuleException;
import gr.evansp.factory.Factory;
import gr.evansp.setup.user.def.models.Address;
import gr.evansp.setup.user.def.persistence.AddressRepository;
import gr.evansp.setup.user.def.questions.NextAddressIdQuestion;
import gr.evansp.setup.user.def.rules.AddressValidator;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.*;

/**
 * Tests for {@link SaveAddressOperationImpl}.
 */
@SuppressWarnings("unchecked")
public class TestSaveAddressOperationImpl {
  SaveAddressOperationImpl sut;

  @Before
  public void setup() {
    sut = Factory.create(SaveAddressOperationImpl.class);
    sut.validator = Mockito.mock(AddressValidator.class);
    sut.question = Mockito.mock(NextAddressIdQuestion.class);
    sut.repository = Mockito.mock(AddressRepository.class);
    sut.setInput(Mockito.mock(Address.class));
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
    doNothing().when(sut.repository).save(isA(Address.class));
    sut.execute();

    verify(sut.question, times(1)).ask();
    verify(sut.question, times(1)).answer();
    verify(sut.validator, times(1)).apply();
    verify(sut.validator, times(1)).setInput(isA(Address.class));
    verify(sut.repository, times(1)).save(isA(Address.class));
    verify(sut.repository, times(0)).update(isA(Address.class));
  }

  @Test
  public void testExecute_update() throws DataException, LogicException, RuleException {
    when(sut.getInput().getAddressId()).thenReturn(1L);
    doNothing().when(sut.validator).apply();
    doNothing().when(sut.question).ask();
    doNothing().when(sut.repository).update(isA(Address.class));

    sut.execute();

    verify(sut.question, times(0)).ask();
    verify(sut.question, times(0)).answer();
    verify(sut.validator, times(1)).apply();
    verify(sut.validator, times(1)).setInput(isA(Address.class));
    verify(sut.repository, times(0)).save(isA(Address.class));
    verify(sut.repository, times(1)).update(isA(Address.class));
  }
}