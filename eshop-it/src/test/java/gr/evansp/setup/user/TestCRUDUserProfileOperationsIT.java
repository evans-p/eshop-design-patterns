package gr.evansp.setup.user;


import gr.evansp.exceptions.DataException;
import gr.evansp.exceptions.LogicException;
import gr.evansp.exceptions.RuleException;
import gr.evansp.factory.Factory;
import gr.evansp.setup.Setup;
import gr.evansp.setup.user.def.models.User;
import gr.evansp.setup.user.def.models.UserProfile;
import gr.evansp.setup.user.def.operations.SaveUserOperation;
import gr.evansp.setup.user.def.operations.SaveUserProfileOperation;
import gr.evansp.setup.user.def.persistence.UserProfileRepository;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Integration test class for {@link UserProfile}.
 */
public class TestCRUDUserProfileOperationsIT extends Setup {

  @Test
  public void testUpdateUserProfile() throws DataException, LogicException, RuleException {
    User user = createSampleUser();
    SaveUserOperation operation = Factory.create(SaveUserOperation.class);
    SaveUserProfileOperation sut = Factory.create(SaveUserProfileOperation.class);
    UserProfileRepository repository = Factory.create(UserProfileRepository.class);
    operation.setInput(user);
    operation.execute();

    UserProfile profile = user.getUserProfile();

    profile.setFirstName("lalala23123");

    sut.setInput(profile);
    sut.execute();

    assertEquals("lalala23123", repository.get(profile).getFirstName());
  }
}
