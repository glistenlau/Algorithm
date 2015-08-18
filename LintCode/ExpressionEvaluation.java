/**
 * Expression Evaluation
 * www.lintcode.com/en/problem/expression-evaluation/
 *
 * Given an expression string array, return the final result of this expression
 *
 * Example
 * For the expression 2 * 6 - (23 + 7) / (1 + 2), return 2.
 */
public class Solution {
  /**
   * @param expression: an array of strings;
   * @return: an integer
   */
  public int evaluateExpression(String[] expression) {
    int[] poriority = new int[expression.length];
    Stack<Integer> operator = new Stack<>();
    Stack<Integer> operand = new Stack<>();
    int base = 0;
    for (int i = 0; i < expression.length; i++) {
      String e = expression[i];
      if (e.equals("(")) {
        base += 10;
        continue;
      }
      if (e.equals(")")) {
        base -= 10;
        continue;
      }
      poriority[i] = getPoriority(e, base);
      if (poriority[i] == 0) {
        operand.push(Integer.parseInt(e));
      } else {
        while (!operator.isEmpty() && poriority[i] <= poriority[operator.peek()]) {
          operand.push(op(operand, expression[operator.pop()]));
        }
        operator.push(i);
      }
    }
    while (!operator.isEmpty()) {
      operand.push(op(operand, expression[operator.pop()]));
    }

    return operand.isEmpty()? 0: operand.pop();
  }

  private int getPoriority(String s, int base) {
    if (s.equals("*") || s.equals("/")) {
      return base + 10;
    }
    if (s.equals("+") || s.equals("-")) {
      return base + 1;
    }
    return 0;
  }

  private int op(Stack<Integer> operand, String e) {
    int a = operand.pop();
    int b = operand.pop();
    if (e.equals("+")) {
      return b + a;
    }
    if (e.equals("-")) {
      return b - a;
    }
    if (e.equals("*")) {
      return b * a;
    }
    if (e.equals("/")) {
      return b / a;
    }

    return -1;
  }
};
