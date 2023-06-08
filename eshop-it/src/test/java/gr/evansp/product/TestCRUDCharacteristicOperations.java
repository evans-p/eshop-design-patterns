package gr.evansp.product;

import gr.evansp.common.DAO;
import gr.evansp.exceptions.DataException;
import gr.evansp.exceptions.LogicException;
import gr.evansp.exceptions.RuleException;
import gr.evansp.factory.Factory;
import gr.evansp.setup.product.def.models.Category;
import gr.evansp.setup.product.def.models.Characteristic;
import gr.evansp.setup.product.def.models.Product;
import gr.evansp.setup.product.def.operations.SaveCategoryOperation;
import gr.evansp.setup.product.def.operations.SaveProductOperation;
import org.junit.Test;

public class TestCRUDCharacteristicOperations extends Setup {
  private AddCharacteristicToProductOperation sut = Factory.create(AddCharacteristicToProductOperation.class);

  @Test
  public void AddCharacteristic_nullProduct() throws DataException, LogicException, RuleException {
    Category category = createSampleCategory();
    Product product = createSampleProduct(category);
    Characteristic characteristic = createSampleCharacteristic(null);

    SaveProductOperation productOperation = Factory.create(SaveProductOperation.class);
    SaveCategoryOperation categoryOperation = Factory.create(SaveCategoryOperation.class);


    categoryOperation.setInput(category);
    categoryOperation.execute();

    productOperation.setInput(product);
    productOperation.execute();

    DAO<Characteristic> dao = Factory.createPersistence(Characteristic.class);
    characteristic.setProduct(product);
    characteristic.setCharacteristicId(1000L);
    dao.save(characteristic);
  }
}
