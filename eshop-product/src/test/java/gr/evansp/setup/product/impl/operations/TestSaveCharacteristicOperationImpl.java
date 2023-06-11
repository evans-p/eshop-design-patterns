package gr.evansp.setup.product.impl.operations;

import gr.evansp.exceptions.DataException;
import gr.evansp.exceptions.LogicException;
import gr.evansp.exceptions.RuleException;
import gr.evansp.factory.Factory;
import gr.evansp.setup.product.def.models.Characteristic;
import gr.evansp.setup.product.def.persistence.CharacteristicRepository;
import gr.evansp.setup.product.def.questions.NextCharacteristicIdQuestion;
import gr.evansp.setup.product.def.rules.CharacteristicValidator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Tester for {@link SaveCharacteristicOperationImpl}
 */
public class TestSaveCharacteristicOperationImpl {

  SaveCharacteristicOperationImpl sut;

  @Before
  public void setup() throws DataException, LogicException, RuleException {
    sut = Factory.create(SaveCharacteristicOperationImpl.class);
    sut.input = mock(Characteristic.class);
    sut.nextCharacteristicIdQuestion = mock(NextCharacteristicIdQuestion.class);
    sut.repository = mock(CharacteristicRepository.class);
    sut.validator = mock(CharacteristicValidator.class);

    doNothing().when(sut.nextCharacteristicIdQuestion).ask();
    when(sut.nextCharacteristicIdQuestion.answer()).thenReturn(1L);
    doNothing().when(sut.repository).save(isA(Characteristic.class));
    doNothing().when(sut.repository).update(isA(Characteristic.class));
    doNothing().when(sut.input).setCharacteristicId(isA(Long.class));
    doNothing().when(sut.validator).setInput(sut.input);
    doNothing().when(sut.validator).apply();
  }

  @Test
  public void testGetInput() {
    Characteristic characteristic = Factory.create(Characteristic.class);
    sut.setInput(characteristic);
    assertEquals(characteristic, sut.getInput());
  }

  @Test(expected = LogicException.class)
  public void testExecute_exception() throws DataException, LogicException, RuleException {
    sut.setInput(null);
    sut.execute();
  }

  @Test
  public void testExecute_new() throws DataException, LogicException, RuleException {
    when(sut.input.getCharacteristicId()).thenReturn(null);
    sut.execute();

    verify(sut.nextCharacteristicIdQuestion, times(1)).ask();
    verify(sut.nextCharacteristicIdQuestion, times(1)).answer();
    verify(sut.validator, times(1)).apply();
    verify(sut.repository, times(1)).save(isA(Characteristic.class));
    verify(sut.repository, times(0)).update(isA(Characteristic.class));
  }

  @Test
  public void testExecute_update() throws DataException, LogicException, RuleException {
    when(sut.input.getCharacteristicId()).thenReturn(1L);
    sut.execute();

    verify(sut.nextCharacteristicIdQuestion, times(0)).ask();
    verify(sut.nextCharacteristicIdQuestion, times(0)).answer();
    verify(sut.validator, times(1)).apply();
    verify(sut.repository, times(0)).save(isA(Characteristic.class));
    verify(sut.repository, times(1)).update(isA(Characteristic.class));
  }
}