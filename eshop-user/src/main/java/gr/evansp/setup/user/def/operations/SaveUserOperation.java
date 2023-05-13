package gr.evansp.setup.user.def.operations;

import gr.evansp.common.Operation;
import gr.evansp.setup.user.def.models.User;

/**
 * An operation to either save a new user to the DB, or update an
 * existing user.
 */
public interface SaveUserOperation extends Operation {
  /**
   * Getter for the input.
   *
   * @return input(User).
   */
  public User getInput();

  /**
   * Setter for the input.
   *
   * @param input User to set.
   */
  public void setInput(User input);
}
