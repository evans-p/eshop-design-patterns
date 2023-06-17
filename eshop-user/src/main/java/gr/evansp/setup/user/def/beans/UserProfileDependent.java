package gr.evansp.setup.user.def.beans;

import gr.evansp.setup.user.def.models.UserProfile;

/**
 * Dependency on {@link UserProfile}
 */
public interface UserProfileDependent {
  /**
   * Getter for UserProfile.
   *
   * @return UserProfile.
   */
  UserProfile getUserProfile();

  /**
   * Setter for UserProfile
   *
   * @param userProfile UserProfile to set.
   */
  void setUserProfile(UserProfile userProfile);
}
