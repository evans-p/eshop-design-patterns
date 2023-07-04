package gr.evansp.exceptions;


/**
 * Exception to be thrown by persistence operations.
 */
public class DataException extends Exception {
  public DataException(String e) {
    super(e);
  }

  public DataException(Throwable e) {
    super(e);
  }
}
