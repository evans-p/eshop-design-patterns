package gr.evansp.setup.user.def.questions;

import gr.evansp.common.Question;
import gr.evansp.setup.user.def.models.User;

/**
 * Checks if the ID of the user provided exists or not.
 */
public interface UserIdExistsQuestion extends Question {
  /**
   * Getter for input
   *
   * @return input
   */
  public User getInput();

  /**
   * setter for input.
   *
   * @param input input
   */
  public void setInput(User input);
}
