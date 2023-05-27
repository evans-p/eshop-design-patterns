package gr.evansp.setup.product.impl.operations;


import gr.evansp.common.DAO;
import gr.evansp.exceptions.DataException;
import gr.evansp.exceptions.LogicException;
import gr.evansp.exceptions.RuleException;
import gr.evansp.factory.Factory;
import gr.evansp.setup.product.def.models.Characteristic;
import gr.evansp.setup.product.def.questions.NextCharacteristicIdQuestion;
import gr.evansp.setup.product.def.rules.CharacteristicValidator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Tests for {@link SaveCharacteristicOperationImpl}
 */
public class TestSaveCharacteristicOperationImpl {
  SaveCharacteristicOperationImpl sut;

  @Before
  public void setUp() throws DataException, LogicException, RuleException {
    sut = Factory.create(SaveCharacteristicOperationImpl.class);
    sut.input = mock(Characteristic.class);
    sut.validator = mock(CharacteristicValidator.class);
    sut.nextCharacteristicIdQuestion = mock(NextCharacteristicIdQuestion.class);
    sut.dao = mock(DAO.class);

    doNothing().when(sut.nextCharacteristicIdQuestion).ask();
    when(sut.nextCharacteristicIdQuestion.answer()).thenReturn(1L);
    doNothing().when(sut.validator).apply();
  }

  @Test
  public void testGetInput() {
    Characteristic c = mock(Characteristic.class);
    sut.setInput(c);
    assertEquals(c, sut.getInput());
  }

  @Test
  public void testSetInput() {
    Characteristic c = sut.getInput();
    verifyNoInteractions(sut.input);
  }

  @Test(expected = LogicException.class)
  public void testExecute_nullInput() throws DataException, LogicException, RuleException {
    sut.setInput(null);
    sut.execute();
  }

  @Test
  public void testExecute_new() throws DataException, LogicException, RuleException {
    when(sut.input.getCharacteristicId()).thenReturn(null);
    sut.execute();
  }

  @Test
  public void testExecute_update() throws DataException, LogicException, RuleException {
    when(sut.input.getCharacteristicId()).thenReturn(1L);
    sut.execute();
  }
}