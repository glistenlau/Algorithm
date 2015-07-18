public class Solution {
  public List<String> generateParenthesis(int n) {
    List<String> result = new ArrayList<String>();

    helper(result, "", n, n);
    return result;
  }

  private void helper(List<String> result, String s, int left, int right) {
    if (left > right || left < 0 || right < 0) {
      return;
    }

    if (left == 0 && right == 0) {
      result.add(s);
    }

    helper(result, s + "(", left - 1, right);
    helper(result, s + ")", left, right - 1);
  }
}