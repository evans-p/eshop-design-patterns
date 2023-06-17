package gr.evansp.setup.user.def.operations;

import gr.evansp.common.Operation;
import gr.evansp.setup.user.def.models.UserProfile;

/**
 * An operation to  update an existing {@link UserProfile} in the db.
 */
public interface SaveUserProfileOperation extends Operation {
  /**
   * Getter for the input.
   *
   * @return input(User).
   */
  UserProfile getInput();

  /**
   * Setter for the input.
   *
   * @param input User to set.
   */
  void setInput(UserProfile input);
}
