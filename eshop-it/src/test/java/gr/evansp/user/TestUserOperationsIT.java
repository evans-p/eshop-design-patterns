package gr.evansp.user;

import gr.evansp.common.DAO;
import gr.evansp.exceptions.DataException;
import gr.evansp.exceptions.LogicException;
import gr.evansp.exceptions.RuleException;
import gr.evansp.factory.Factory;
import gr.evansp.setup.user.def.models.User;
import gr.evansp.setup.user.def.operations.SaveUserOperation;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Random;

/**
 * Integration test class for {@link User}.
 */
public class TestUserOperationsIT extends Setup {
  @Test
  public void testSaveUser_noId() throws DataException, LogicException, RuleException {
    User user = createSampleUser(null);
    SaveUserOperation sut = Factory.create(SaveUserOperation.class);
    sut.setInput(user);
    sut.execute();
  }

  @Test
  public void testSaveUser() throws DataException, LogicException, RuleException {
    Random random = new Random();
    User user = createSampleUser(random.nextLong());
    SaveUserOperation sut = Factory.create(SaveUserOperation.class);
    sut.setInput(user);
    sut.execute();
  }

  @Test
  public void testDeleteUser() throws DataException, LogicException, RuleException {
    Random random = new Random();
    User user = createSampleUser(random.nextLong());
    SaveUserOperation sut = Factory.create(SaveUserOperation.class);
    sut.setInput(user);
    sut.execute();

    DAO<User> dao = Factory.createPersistence(User.class);
    dao.delete(user);

    Assert.assertNull(dao.get(user.getUserId()));
  }

  @Test
  public void testUpdateUser() throws DataException, LogicException, RuleException {
    Random random = new Random();
    User user = createSampleUser(random.nextLong());
    SaveUserOperation sut = Factory.create(SaveUserOperation.class);
    sut.setInput(user);
    sut.execute();

    user = sut.getInput();

    user.setEmail(generateRandomNumber() + "qwe@example.com");
    sut.setInput(user);
    sut.execute();

    DAO<User> dao = Factory.createPersistence(User.class);
    User returned = dao.get(user.getUserId());
    Assert.assertEquals(user, returned);
    Assert.assertEquals(user.getEmail(), returned.getEmail());
  }

  @Test
  public void testGetAllUsers() throws DataException, LogicException, RuleException {
    DAO<User> dao = Factory.createPersistence(User.class);
    List<User> returned = dao.getAll();
    Assert.assertTrue(!returned.isEmpty());
  }
}
