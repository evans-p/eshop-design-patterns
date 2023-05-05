package gr.evansp.rules;

public class RuleUtils {
  //private constructor
  private RuleUtils() {
    //EMPTY
  }

  public static boolean checkContainsOnlyNumbers(String str) {
    return str.matches("^[0-9]+$");
  }

  public static boolean checkContainsOnlyLetters(String str) {
    return str.matches("^[a-zA-Z]+$");
  }
}
