package gr.evansp.setup.user.def.questions;

import gr.evansp.common.Question;
import gr.evansp.setup.user.def.models.User;

/**
 * Checks it the email of the user provided already exists.
 */
public interface UserEmailExistsQuestion extends Question<Boolean> {
  /**
   * Getter for input
   *
   * @return input
   */
  User getInput();

  /**
   * setter for input.
   *
   * @param input input
   */
  void setInput(User input);
}
