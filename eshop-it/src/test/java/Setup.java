import gr.evansp.factory.Factory;
import gr.evansp.setup.user.def.models.User;
import gr.evansp.setup.user.def.models.UserProfile;

import java.util.Calendar;

/**
 * Setup class for Integration Tests. Creates sample Objects.
 */
public class Setup {
  /**
   * Empty Noarg Constructor.
   */
  private Setup() {
    //EMPTY
  }

  public static User createSampleUser(Long id) {
    User user = Factory.create(User.class);
    UserProfile profile = Factory.create(UserProfile.class);

    user.setUserId(id);
    user.setEmail("example");
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
}
