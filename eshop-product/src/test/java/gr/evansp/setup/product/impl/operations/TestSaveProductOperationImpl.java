package gr.evansp.setup.product.impl.operations;


import gr.evansp.exceptions.DataException;
import gr.evansp.exceptions.LogicException;
import gr.evansp.exceptions.RuleException;
import gr.evansp.factory.Factory;
import gr.evansp.setup.product.def.models.Characteristic;
import gr.evansp.setup.product.def.models.Product;
import gr.evansp.setup.product.def.persistence.ProductRepository;
import gr.evansp.setup.product.def.questions.NextCharacteristicIdQuestion;
import gr.evansp.setup.product.def.questions.NextProductIdQuestion;
import gr.evansp.setup.product.def.rules.ProductValidator;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.*;

/**
 * Tester for {@link SaveProductOperationImpl}
 */
public class TestSaveProductOperationImpl {
  SaveProductOperationImpl sut;

  @Before
  public void setUp() throws DataException, LogicException, RuleException {
    Characteristic characteristic = mock(Characteristic.class);
    sut = Factory.create(SaveProductOperationImpl.class);
    sut.repository = mock(ProductRepository.class);
    sut.nextProductIdQuestion = mock(NextProductIdQuestion.class);
    sut.nextCharacteristicIdQuestion = mock(NextCharacteristicIdQuestion.class);
    sut.validator = mock(ProductValidator.class);
    sut.input = mock(Product.class);

    doNothing().when(sut.nextProductIdQuestion).ask();
    when(sut.nextProductIdQuestion.answer()).thenReturn(1L);
    doNothing().when(sut.validator).setInput(isA(Product.class));
    when(sut.input.getCharacteristics()).thenReturn(Set.of(characteristic));
    doNothing().when(sut.validator).apply();
    doNothing().when(sut.repository).save(isA(Product.class));
    doNothing().when(sut.repository).update(isA(Product.class));
    doNothing().when(sut.nextCharacteristicIdQuestion).ask();
    when(characteristic.getCharacteristicId()).thenReturn(null);
    doNothing().when(characteristic).setCharacteristicId(any(Long.class));
    doNothing().when(characteristic).setProductId(any(Long.class));
    doNothing().when(characteristic).setCategoryId(any(Long.class));
  }

  @Test(expected = LogicException.class)
  public void testExecute_null() throws DataException, LogicException, RuleException {
    sut.setInput(null);
    sut.execute();
  }

  @Test
  public void testExecute_new() throws DataException, LogicException, RuleException {
    when(sut.getInput().getProductId()).thenReturn(null);
    sut.execute();
  }

  @Test
  public void testExecute_update() throws DataException, LogicException, RuleException {
    when(sut.getInput().getProductId()).thenReturn(1L);
    sut.execute();
  }
}