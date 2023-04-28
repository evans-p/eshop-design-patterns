package gr.evansp.setup.user.def.beans;

import gr.evansp.setup.user.def.models.User;

/**
 * Dependency on {@link User}
 */
public interface UserDependent {
  /**
   * Getter for user.
   *
   * @return user
   */
  public User getUser();

  /**
   * Setter for user.
   *
   * @param user user to set.
   */
  public void setUser(User user);
}
