package gr.evansp.setup.product.impl.operations;

import gr.evansp.common.DAO;
import gr.evansp.exceptions.DataException;
import gr.evansp.exceptions.LogicException;
import gr.evansp.exceptions.RuleException;
import gr.evansp.factory.Factory;
import gr.evansp.setup.product.def.models.Characteristic;
import gr.evansp.setup.product.def.models.Product;
import gr.evansp.setup.product.def.operations.SaveProductOperation;
import gr.evansp.setup.product.def.questions.NextCharacteristicIdQuestion;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

/**
 * Tests for {@link AddCharacteristicToProductOperationImpl}
 */
public class TestAddCharacteristicToProductOperationImpl {
  private AddCharacteristicToProductOperationImpl sut;


  @Before
  public void setUp() throws DataException, LogicException, RuleException {
    sut = Factory.create(AddCharacteristicToProductOperationImpl.class);

    sut.characteristic = mock(Characteristic.class);
    sut.productId = 1L;

    sut.characteristicIdQuestion = mock(NextCharacteristicIdQuestion.class);
    sut.operation = mock(SaveProductOperation.class);
    sut.dao = mock(DAO.class);
  }

  @Test
  public void testGetProductId() {
    sut.setProductId(1L);
    assertNotNull(sut.getProductId());
  }

  @Test
  public void testSetProductId() {
    Long id = 1L;
    sut.setProductId(id);
    assertEquals(sut.getProductId(), id);
  }

  @Test
  public void testGetCharacteristic() {
    sut.setCharacteristic(mock(Characteristic.class));
    assertNotNull(sut.getCharacteristic());
  }

  @Test
  public void testSetCharacteristic() {
    Characteristic characteristic = mock(Characteristic.class);
    sut.setCharacteristic(characteristic);
    assertEquals(sut.getCharacteristic(), characteristic);
  }

  @Test(expected = LogicException.class)
  public void testExecute_nullProductId() throws DataException, LogicException, RuleException {
    sut.setProductId(null);
    sut.setCharacteristic(mock(Characteristic.class));
    sut.execute();
  }

  @Test(expected = LogicException.class)
  public void testExecute_nullCharacteristic() throws DataException, LogicException, RuleException {
    sut.setCharacteristic(null);
    sut.setProductId(1L);
    sut.execute();
  }

  @Test
  public void testExecute_ok() throws DataException, LogicException, RuleException {
    when(sut.characteristic.getCharacteristicId()).thenReturn(1L);
    when(sut.dao.get(anyLong())).thenReturn(mock(Product.class));
    doNothing().when(sut.operation).execute();
    sut.execute();
  }

  @Test
  public void testExecute_nullCharacteristicId() throws DataException, LogicException, RuleException {
    when(sut.characteristic.getCharacteristicId()).thenReturn(null);
    doNothing().when(sut.characteristicIdQuestion).ask();
    when(sut.characteristicIdQuestion.answer()).thenReturn(1L);
    when(sut.dao.get(anyLong())).thenReturn(mock(Product.class));

    doNothing().when(sut.operation).execute();

    sut.execute();
  }
}