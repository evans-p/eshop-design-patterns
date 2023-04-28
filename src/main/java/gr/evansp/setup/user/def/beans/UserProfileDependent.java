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
  public UserProfile getUserProfile();

  /**
   * Setter for UserProfile
   *
   * @param userProfile UserProfile to set.
   */
  public void setUserProfile(UserProfile userProfile);
}
