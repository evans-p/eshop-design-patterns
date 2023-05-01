package gr.evansp.beans;

/**
 * Something with a value
 */
public interface Value {
  /**
   * Getter for value.
   *
   * @return value.
   */
  public String getValue();

  /**
   * Setter for value.
   *
   * @param value value to set.
   */
  public void setValue(String value);
}
