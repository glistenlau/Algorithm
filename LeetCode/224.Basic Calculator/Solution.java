public class Solution {
  public class PriorityNode {
    int val;
    char str;

    PriorityNode(int val, char str) {
      this.val = val;
      this.str = str;
    }
  }

  public int calculate(String s) {
    int left = 0;
    while (s.charAt(left) == ' ') {
      left++;
    }
    int right = s.length() - 1;
    while (s.charAt(right) == ' ') {
      right--;
    }
    int ans;

    Stack<PriorityNode> operator = new Stack<>();
    Stack<Integer> operands = new Stack<>();

    int base = 0;
    while (left <= right) {
      if (Character.isDigit(s.charAt(left))) {
        int start = left;
        while (left <= right && Character.isDigit(s.charAt(left))) {
          left++;
        }
        operands.push(Integer.parseInt(s.substring(start, left)));
      } else {
        PriorityNode cur = null;
        if (s.charAt(left) == '(') {
          base += 10;
        } else if (s.charAt(left) == ')') {
          base -= 10;
        } else if (s.charAt(left) == '+' || s.charAt(left) == '-') {
          cur = new PriorityNode(base + 1, s.charAt(left));
        } else if (s.charAt(left) == '*' || s.charAt(left) == '/') {
          cur = new PriorityNode(base + 10, s.charAt(left));
        }

        if (cur != null) {
          while (!operator.isEmpty() && cur.val <= operator.peek().val) {
            operands.push(op(operands.pop(), operands.pop(), operator.pop().str));
          }
          operator.push(cur);
        }
        left++;
      }
    }

    while (!operator.isEmpty()) {
      operands.push(op(operands.pop(), operands.pop(), operator.pop().str));
    }
    return operands.isEmpty()? 0: operands.pop();
  }

  private int op(int a, int b, char operator) {
    if (operator == '+') {
      return b + a;
    } else if (operator == '-') {
      return b - a;
    } else if (operator == '*') {
      return b * a;
    } else {
      return b / a;
    }
  }
}