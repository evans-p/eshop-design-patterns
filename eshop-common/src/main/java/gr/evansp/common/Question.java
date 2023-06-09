package gr.evansp.common;

import gr.evansp.exceptions.DataException;
import gr.evansp.exceptions.LogicException;

/**
 * Interface to be used for questions towards the DB.
 */
public interface Question<T> extends Entity {
  /**
   * Asks the question.
   */
  void ask() throws DataException, LogicException;

  /**
   * Gets the answer of the question.
   *
   * @return Result of the question.
   */
  T answer();
}
