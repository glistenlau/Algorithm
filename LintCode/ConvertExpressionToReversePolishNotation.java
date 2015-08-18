/**
 * Convert Expression to Reverse Polish Notation
 * www.lintcode.com/en/problem/convert-expression-to-reverse-polish-notation/
 *
 * Given an expression string array, return the Reverse Polish notation of this expression. (remove the parentheses).
 *
 * Example
 * For the expression [3 - 4 + 5], return [3 4 - 5 +].
 */
public class Solution {
  /**
   * @param expression: A string array
   * @return: The Reverse Polish notation of this expression
   */
  public ArrayList<String> convertToRPN(String[] expression) {
    // write your code here
    ArrayList<String> result = new ArrayList<>();
    int[] poriority = new int[expression.length];
    int base = 0;
    for (int i = 0; i < expression.length; i++) {
      String e = expression[i];
      if (e.equals("+") || e.equals("-")) {
        poriority[i] = base + 1;
      } else if (e.equals("*") || e.equals("/")) {
        poriority[i] = base + 10;
      } else if (e.equals("(")) {
        base += 10;
      } else if (e.equals(")")) {
        base -= 10;
      }
    }

    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < expression.length; i++) {
      String e = expression[i];
      if (e.equals(")") || e.equals("(")) {
        continue;
      }
      if (poriority[i] == 0) {
        result.add(expression[i]);
      } else {
        while (!stack.isEmpty() && poriority[i] <= poriority[stack.peek()]) {
          result.add(expression[stack.pop()]);
        }
        stack.push(i);
      }
    }

    while (!stack.isEmpty()) {
      result.add(expression[stack.pop()]);
    }

    return result;
  }
}
