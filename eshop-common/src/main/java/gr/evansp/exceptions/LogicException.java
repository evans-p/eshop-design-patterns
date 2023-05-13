package gr.evansp.exceptions;

import gr.evansp.common.Operation;

/**
 * Exception to be thrown by an {@link Operation} when an error occurs
 * during the operation.
 */
public class LogicException extends Exception {
  public LogicException(String e) {
    super(e);
  }
}
