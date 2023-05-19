package gr.evansp.user;

import gr.evansp.exceptions.DataException;
import gr.evansp.exceptions.LogicException;
import gr.evansp.exceptions.RuleException;
import gr.evansp.factory.Factory;
import gr.evansp.setup.user.def.models.User;
import gr.evansp.setup.user.def.models.UserProfile;
import gr.evansp.setup.user.def.operations.SaveUserOperation;
import org.junit.Test;

import java.util.Calendar;

/**
 * Integration test class for user.
 */
public class TestSaveUserOperation {

  public static User createSampleUser(Long id) {
    User user = Factory.create(User.class);
    UserProfile profile = Factory.create(UserProfile.class);

    user.setUserId(id);
    user.setEmail("example@example.com");
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
}
