package gr.evansp.exceptions;

import gr.evansp.common.Rule;

/**
 * Exception to be thrown by a {@link Rule} when input objects do not
 * validate.
 */
public class RuleException extends Exception {
  public RuleException(String e) {
    super(e);
  }
}