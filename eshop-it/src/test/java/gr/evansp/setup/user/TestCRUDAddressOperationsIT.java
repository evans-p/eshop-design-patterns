package gr.evansp.setup.user;

import gr.evansp.exceptions.DataException;
import gr.evansp.exceptions.LogicException;
import gr.evansp.exceptions.RuleException;
import gr.evansp.factory.Factory;
import gr.evansp.setup.Setup;
import gr.evansp.setup.user.def.models.Address;
import gr.evansp.setup.user.def.models.User;
import gr.evansp.setup.user.def.operations.SaveAddressOperation;
import gr.evansp.setup.user.def.operations.SaveUserOperation;
import gr.evansp.setup.user.def.persistence.AddressRepository;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Integration test class for {@link Address}.
 */
public class TestCRUDAddressOperationsIT extends Setup {
  User user;

  @Before
  public void setUp() throws DataException, LogicException, RuleException {
    user = createSampleUser();
    SaveUserOperation sut = Factory.create(SaveUserOperation.class);
    sut.setInput(user);
    sut.execute();
  }

  @Test
  public void testCreateNewAddress() throws DataException, LogicException, RuleException {
    Address address = createSampleAddress(null, user.getUserId());
    AddressRepository repository = Factory.create(AddressRepository.class);
    SaveAddressOperation sut = Factory.create(SaveAddressOperation.class);

    sut.setInput(address);
    sut.execute();

    assertNotNull(repository.get(address));
  }


  @Test
  public void testUpdateAddress() throws DataException, LogicException, RuleException {
    Address address = createSampleAddress(null, user.getUserId());
    AddressRepository repository = Factory.create(AddressRepository.class);
    SaveAddressOperation sut = Factory.create(SaveAddressOperation.class);

    sut.setInput(address);
    sut.execute();

    address.setCountry("Albania");
    sut.execute();

    assertEquals("Albania", repository.get(address).getCountry());
  }


  @Test
  public void testDeleteAddress() throws DataException, LogicException, RuleException {
    Address address = createSampleAddress(null, user.getUserId());
    AddressRepository repository = Factory.create(AddressRepository.class);
    SaveAddressOperation sut = Factory.create(SaveAddressOperation.class);

    sut.setInput(address);
    sut.execute();

    repository.delete(address);

    assertNull(repository.get(address));
  }


  @Test
  public void testGetAll() throws DataException {
    AddressRepository repository = Factory.create(AddressRepository.class);

    assertFalse(repository.getAll().isEmpty());
  }
}
