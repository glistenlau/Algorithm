public class Solution {
  public int evalRPN(String[] tokens) {
    if (tokens == null || tokens.length == 0) {
      return 0;
    }

    Deque<String> nums = new ArrayDeque<>();

    for (String token: tokens) {
      if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
        nums.push(op(nums.pop(), nums.pop(), token));
      } else {
        nums.push(token);
      }
    }

    return Integer.parseInt(nums.pop());
  }

  private String op(String a, String b, String operation) {
    int n1 = Integer.parseInt(a);
    int n2 = Integer.parseInt(b);
    int result = 0;
    if (operation.equals("+")) {
      result = n2 + n1;
    } else if (operation.equals("-")) {
      result = n2 - n1;
    } else if (operation.equals("*")) {
      result = n2 * n1;
    } else if (operation.equals("/")) {
      result = n2 / n1;
    }

    return String.valueOf(result);
  }
}