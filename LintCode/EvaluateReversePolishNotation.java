/**
 * Evaluate Reverse Polish Notation
 * www.lintcode.com/en/problem/evaluate-reverse-polish-notation/
 *
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * Valid operators are +, -, *, /. Each operand may be integer or another expression.
 */
public class Solution {
  /**
   * @param tokens The Reverse Polish Notation
   * @return the value
   */
  public int evalRPN(String[] tokens) {
    if (tokens == null || tokens.length == 0) {
      return 0;
    }

    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < tokens.length; i++) {
      if (Character.isDigit(tokens[i].charAt(tokens[i].length() - 1))) {
        stack.push(Integer.parseInt(tokens[i]));
      } else {
        stack.push(op(stack.pop(), stack.pop(), tokens[i]));
      }
    }

    return stack.pop();
  }

  private int op(int a, int b, String operator) {
    if (operator.equals("+")) {
      return b + a;
    } else if (operator.equals("-")) {
      return b - a;
    } else if (operator.equals("*")) {
      return b * a;
    } else {
      return b / a;
    }
  }
}
