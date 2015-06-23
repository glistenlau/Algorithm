import java.util.ArrayList;
import java.util.List;

/**
 * Created by YiLIU on 6/15/15.
 */
public class LetterCombinationsOfAPhoneNumber {
  private static String[] lookup = {"", "", "abc", "def", "ghi", "jkl", "mno",
      "pqrs", "tuv", "wxyz"};
  private List<String> result = new ArrayList<>();

  private void letterCombinationsHelper(String digits, String taken) {
    if (digits.length() == 0) {
      return;
    }
    int cur = Integer.parseInt(digits.substring(0, 1));
    for (int i = 0; i < lookup[cur].length(); ++i) {
      String temp = taken;
      temp += Character.toString(lookup[cur].charAt(i));
      if (digits.length() == 1) {
        result.add(temp);
      } else {
        letterCombinationsHelper(digits.substring(1), temp);
      }
    }
  }

  public List<String> letterCombinations(String digits) {
    letterCombinationsHelper(digits, "");
    return result;
  }

  public static void main(String[] args) {
    System.out.println(new LetterCombinationsOfAPhoneNumber()
        .letterCombinations("23"));
  }
}
