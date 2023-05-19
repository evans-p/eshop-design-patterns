package gr.evansp.user;

import gr.evansp.common.DAO;
import gr.evansp.exceptions.DataException;
import gr.evansp.exceptions.LogicException;
import gr.evansp.exceptions.RuleException;
import gr.evansp.factory.Factory;
import gr.evansp.setup.user.def.models.User;
import gr.evansp.setup.user.def.models.UserProfile;
import gr.evansp.setup.user.def.operations.SaveUserOperation;
import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;
import java.util.List;
import java.util.Random;

/**
 * Integration test class for user.
 */
public class TestUserOperationsIT {

  public static int generateRandomNumber() {
    Random r = new Random();
    int low = 10;
    int high = 10000;
    return r.nextInt(high - low) + low;
  }

  public static User createSampleUser(Long id) {
    User user = Factory.create(User.class);
    UserProfile profile = Factory.create(UserProfile.class);

    user.setUserId(id);
    user.setEmail(generateRandomNumber() + "example@example.com");
    user.setPassword("12345678@asd");


    profile.setUserId(id);
    profile.setFirstName("Evans");
    profile.setLastName("Poulakis");
    profile.setPhoneNo("6978418570");
    profile.setDateAdded(Calendar.getInstance().getTime());
    profile.setDateLastModified(Calendar.getInstance().getTime());

    user.setUserProfile(profile);
    return user;
  }

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
  }
}
