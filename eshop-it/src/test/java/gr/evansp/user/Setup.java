package gr.evansp.user;

import gr.evansp.factory.Factory;
import gr.evansp.setup.user.def.models.Address;
import gr.evansp.setup.user.def.models.User;
import gr.evansp.setup.user.def.models.UserProfile;

import java.util.Calendar;
import java.util.Random;

public class Setup {
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

  public static Address createSampleAddress() {
    Address address = Factory.create(Address.class);

    address.setPostalCode("123");
    address.setCountry("example");
    address.setCity("example");
    address.setStreetName("example");
    address.setStreetNumber("123");

    return address;
  }
}
