package gr.evansp.common;

import gr.evansp.exceptions.DataException;
import gr.evansp.exceptions.LogicException;
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
  T getInput();

  /**
   * Setter for validator input.
   *
   * @param input intput to set.
   */
  void setInput(T input);

  /**
   * Main method of validator. Called to validate input object.
   * If the input object fails to validate throws exceptions.
   *
   * @throws RuleException-  dummy
   * @throws DataException-  dummy
   * @throws LogicException- dummy
   */
  void apply() throws RuleException, DataException, LogicException;

}
