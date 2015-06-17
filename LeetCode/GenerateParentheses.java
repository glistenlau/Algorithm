import java.util.ArrayList;
import java.util.List;

/**
 * Created by YiLIU on 6/17/15.
 */
public class GenerateParentheses {
  public List<String> generateParenthesis(int n) {
    List<String> result = new ArrayList<>();
    helper(n, n, "", result);
    return result;
  }

  private void helper(int left, int right, String s, List<String> result) {
    if (left > right || left < 0 || right < 0) {
      return;
    }

    if (left == 0 && right == 0) {
      result.add(s);
      return;
    }

    helper(left - 1, right, s + "(", result);
    helper(left, right - 1, s + ")", result);
  }
}
