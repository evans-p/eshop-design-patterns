package gr.evansp.user;


import gr.evansp.common.DAO;
import gr.evansp.exceptions.DataException;
import gr.evansp.exceptions.LogicException;
import gr.evansp.exceptions.RuleException;
import gr.evansp.factory.Factory;
import gr.evansp.setup.user.def.models.User;
import gr.evansp.setup.user.def.models.UserProfile;
import gr.evansp.setup.user.def.operations.SaveUserProfileOperation;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Integration test class for {@link UserProfile}.
 */
public class TestCRUDUserProfileOperationsIT extends Setup {

  @Test
  public void testSaveNewUserProfile() throws DataException, LogicException, RuleException {
    DAO<User> userDAO = Factory.createPersistence(User.class);
    List<User> users = userDAO.getAll();
    UserProfile userProfile = createSampleUserProfile(users.get(0).getUserId());
    SaveUserProfileOperation sut = Factory.create(SaveUserProfileOperation.class);
    sut.setInput(userProfile);
    sut.execute();
  }

  @Test
  public void testDeleteUserProfile() throws DataException, LogicException, RuleException {
    DAO<User> userDAO = Factory.createPersistence(User.class);
    DAO<UserProfile> userProfileDAO = Factory.createPersistence(UserProfile.class);
    List<User> users = userDAO.getAll();
    Long id;
    for (User user : users) {
      if (user.getUserProfile() != null) {
        id = user.getUserId();
        userProfileDAO.delete(user.getUserProfile());
        assertNull(userDAO.get(id).getUserProfile());
        assertNull(userProfileDAO.get(id));
        return;
      }
    }
  }


  @Test
  public void testUpdateUserProfile() throws DataException, LogicException, RuleException {
    DAO<User> userDAO = Factory.createPersistence(User.class);
    DAO<UserProfile> userProfileDAO = Factory.createPersistence(UserProfile.class);
    List<User> users = userDAO.getAll();
    Long id;
    for (User user : users) {
      if (user.getUserProfile() != null) {
        id = user.getUserId();
        user.getUserProfile().setLastName("QQQQ");
        userProfileDAO.update(user.getUserProfile());
        assertEquals(userProfileDAO.get(id).getLastName(), userDAO.get(id).getUserProfile().getLastName());
        return;
      }
    }
  }

  @Test
  public void testGetAllProfile() throws DataException, LogicException, RuleException {
    DAO<UserProfile> userProfileDAO = Factory.createPersistence(UserProfile.class);
    assertNotNull(userProfileDAO.getAll());
    assertFalse(userProfileDAO.getAll().isEmpty());
  }
}
