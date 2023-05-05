package gr.evansp.common;

import gr.evansp.exceptions.RuleException;

/**
 * Validation Interface for application Entities.
 *
 * @param <T>
 */
public interface Rule<T extends Entity> extends Entity {
  /**
   * Getter for validator input.
   *
   * @return input
   */
  public T getInput();

  /**
   * Setter for validator input.
   *
   * @param input intput to set.
   */
  public void setInput(T input);

  /**
   * Main method of validator. Called to validate input object.
   * If the input object fails to validate, throws {@link RuleException}.
   */
  public void apply() throws RuleException;

}
