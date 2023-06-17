package gr.evansp.setup.user.def.beans;

import gr.evansp.setup.user.def.models.User;

/**
 * Dependency on {@link User}
 */
@SuppressWarnings("unused")
public interface UserDependent {
  /**
   * Getter for user.
   *
   * @return user
   */
  User getUser();

  /**
   * Setter for user.
   *
   * @param user user to set.
   */
  void setUser(User user);
}
