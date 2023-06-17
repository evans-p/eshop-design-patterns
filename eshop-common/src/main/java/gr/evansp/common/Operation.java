package gr.evansp.common;

import gr.evansp.exceptions.DataException;
import gr.evansp.exceptions.LogicException;
import gr.evansp.exceptions.RuleException;

/**
 * An interface that represents all the operation to be performed
 * in the system.
 */
public interface Operation extends Entity {

  /**
   * Main method of the operation. to be called to execute the operation.
   */
  void execute() throws DataException, RuleException, LogicException;
}
