package gr.evansp.rules;

import gr.evansp.common.Rule;

/**
 * Utility method for {@link Rule}.
 */
public class RuleUtils {
  /**
   * private constructor
   */
  private RuleUtils() {
    //EMPTY
  }

  public static boolean checkContainsOnlyNumbers(String str) {
    return !str.matches("^[0-9]+$");
  }

  public static boolean checkContainsOnlyLetters(String str) {
    return !str.matches("^[a-zA-Z]+$");
  }

  public static boolean checkContainsSymbol(String str) {
    Character[] characters = {'!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '_', '-', '+', '='};

    for (Character c : characters) {
      if (str.contains(c.toString())) {
        return true;
      }
    }
    return false;
  }

  public static boolean checkContainsLetter(String str) {
    return str.matches(".*[a-zA-Z].*");
  }

  public static boolean checkContainsNumber(String str) {
    return str.matches(".*[0-9].*");
  }
}
