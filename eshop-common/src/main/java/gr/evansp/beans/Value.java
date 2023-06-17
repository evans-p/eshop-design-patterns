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
  String getValue();

  /**
   * Setter for value.
   *
   * @param value value to set.
   */
  void setValue(String value);
}
