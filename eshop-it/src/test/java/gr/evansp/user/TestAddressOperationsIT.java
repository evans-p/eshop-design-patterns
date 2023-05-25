package gr.evansp.user;

import gr.evansp.common.DAO;
import gr.evansp.exceptions.DataException;
import gr.evansp.exceptions.LogicException;
import gr.evansp.exceptions.RuleException;
import gr.evansp.factory.Factory;
import gr.evansp.setup.user.def.models.Address;
import gr.evansp.setup.user.def.models.User;
import gr.evansp.setup.user.def.operations.SaveAddressOperation;
import gr.evansp.setup.user.def.operations.SaveUserOperation;
import org.junit.Assert;
import org.junit.Test;

/**
 * Integration test class for {@link Address}.
 */
public class TestAddressOperationsIT extends Setup {
  @Test
  public void TestSaveNewAddress() throws DataException, LogicException, RuleException {
    User user = createSampleUser(null);
    SaveUserOperation sut2 = Factory.create(SaveUserOperation.class);
    sut2.setInput(user);
    sut2.execute();

    Address address = createSampleAddress();
    address.setUserProfile(user.getUserProfile());
    SaveAddressOperation sut = Factory.create(SaveAddressOperation.class);
    sut.setInput(address);
    sut.execute();
    DAO<Address> dao = Factory.createPersistence(Address.class);

    Assert.assertEquals(dao.get(sut.getInput().getAddressId()), sut.getInput());
  }

  @Test
  public void TestDeleteAddress() throws DataException, LogicException, RuleException {
    User user = createSampleUser(null);
    SaveUserOperation sut2 = Factory.create(SaveUserOperation.class);
    sut2.setInput(user);
    sut2.execute();

    Address address = createSampleAddress();
    address.setUserProfile(user.getUserProfile());
    SaveAddressOperation sut = Factory.create(SaveAddressOperation.class);
    sut.setInput(address);
    sut.execute();
    DAO<Address> dao = Factory.createPersistence(Address.class);
    dao.delete(sut.getInput());
    Assert.assertNull(dao.get(sut.getInput().getAddressId()));
  }

  @Test
  public void TestUpdateAddress() throws DataException, LogicException, RuleException {
    User user = createSampleUser(null);
    SaveUserOperation sut2 = Factory.create(SaveUserOperation.class);
    sut2.setInput(user);
    sut2.execute();

    Address address = createSampleAddress();
    address.setUserProfile(user.getUserProfile());
    SaveAddressOperation sut = Factory.create(SaveAddressOperation.class);
    sut.setInput(address);
    sut.execute();

    DAO<Address> dao = Factory.createPersistence(Address.class);
    Address returned = dao.get(sut.getInput().getAddressId());

    Assert.assertEquals(returned, address);

    returned.setCity("AncientEpidauros");
    sut.setInput(returned);
    sut.execute();
    returned = dao.get(sut.getInput().getAddressId());
    Assert.assertNotEquals(returned.getCity(), address.getCity());
  }
}
