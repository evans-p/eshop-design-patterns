package gr.evansp.setup.product;

import gr.evansp.exceptions.DataException;
import gr.evansp.exceptions.LogicException;
import gr.evansp.exceptions.RuleException;
import gr.evansp.factory.Factory;
import gr.evansp.setup.Setup;
import gr.evansp.setup.product.def.models.Category;
import gr.evansp.setup.product.def.models.Characteristic;
import gr.evansp.setup.product.def.models.Product;
import gr.evansp.setup.product.def.operations.SaveCategoryOperation;
import gr.evansp.setup.product.def.operations.SaveCharacteristicOperation;
import gr.evansp.setup.product.def.operations.SaveProductOperation;
import gr.evansp.setup.product.def.persistence.CharacteristicRepository;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Integration tests for {@link Characteristic} operations.
 */
public class TestCRUDCharacteristicOperations extends Setup {
  Category category;
  Product product;

  @Before
  public void setUp() throws DataException, LogicException, RuleException {
    category = createSampleCategory(null);
    SaveCategoryOperation categoryOperation = Factory.create(SaveCategoryOperation.class);
    categoryOperation.setInput(category);
    categoryOperation.execute();

    product = createSampleProduct(null, category.getCategoryId());
    SaveProductOperation productOperation = Factory.create(SaveProductOperation.class);
    productOperation.setInput(product);
    productOperation.execute();
  }

  @Test
  public void testSaveNewCharacteristic() throws DataException, LogicException, RuleException {
    Characteristic characteristic = createSampleCharacteristic(
        product.getProductId(), null, category.getCategoryId());
    SaveCharacteristicOperation sut = Factory.create(SaveCharacteristicOperation.class);
    CharacteristicRepository repository = Factory.create(CharacteristicRepository.class);

    sut.setInput(characteristic);
    sut.execute();
    assertNotNull(repository.get(characteristic));
    assertEquals(characteristic, repository.get(characteristic));
  }


  @Test
  public void testUpdateCharacteristic() throws DataException, LogicException, RuleException {
    Characteristic characteristic = createSampleCharacteristic(
        product.getProductId(), null, category.getCategoryId());
    SaveCharacteristicOperation sut = Factory.create(SaveCharacteristicOperation.class);
    CharacteristicRepository repository = Factory.create(CharacteristicRepository.class);

    sut.setInput(characteristic);
    sut.execute();

    characteristic.setName("lalala");
    sut.execute();

    assertEquals("lalala", repository.get(characteristic).getName());
  }


  @Test
  public void testDeleteCharacteristic() throws DataException, LogicException, RuleException {
    Characteristic characteristic = createSampleCharacteristic(
        product.getProductId(), null, category.getCategoryId());
    SaveCharacteristicOperation sut = Factory.create(SaveCharacteristicOperation.class);
    CharacteristicRepository repository = Factory.create(CharacteristicRepository.class);

    sut.setInput(characteristic);
    sut.execute();

    repository.delete(characteristic);

    assertNull(repository.get(characteristic));
  }

  @Test
  public void testGetAll() throws DataException {

    CharacteristicRepository repository = Factory.create(CharacteristicRepository.class);
    assertTrue(repository.getAll().size() > 0);
  }
}
