public class Solution {
  public List<String> addOperators(String num, int target) {
    List<String> ans = new ArrayList<>();
    if (num == null || num.length() < 2) {
      return ans;
    }
    StringBuilder sb = new StringBuilder(num);
    dfsHelper(sb, target, 1, ans);

    return ans;
  }

  private void dfsHelper(StringBuilder sb, int target, int pos, List<String> ans) {
    String str = sb.toString();
    if (calculate(str) == (long)target) {
      ans.add(str);
    }
    if (pos >= sb.length()) {
      return;
    }

    char[] operators = {'*', '+', '-'};

    for (int i = pos; i < sb.length(); i++) {
      for (int j = 0; j < 3; j++) {
        sb.insert(i, operators[j]);
        dfsHelper(sb, target, i + 2, ans);
        sb.deleteCharAt(i);
      }
      if (sb.charAt(pos - 1) == '0') {
        break;
      }
    }
  }

  private long calculate(String str) {
    Stack<Character> operators = new Stack<>();
    Stack<Long> operands = new Stack<>();

    for (int i = 0; i < str.length(); i++) {
      char cur = str.charAt(i);
      if (Character.isDigit(cur)) {
        int j = i + 1;
        while (j < str.length() && Character.isDigit(str.charAt(j))) {
          j++;
        }
        if (str.charAt(i) == '0' && j - i > 1) {
          return (long)Integer.MAX_VALUE + 1;
        }
        operands.push(Long.parseLong(str.substring(i, j)));
        i = j - 1;
      } else {
        if (operators.isEmpty()) {
          operators.push(cur);
        } else if ((operators.peek() == '+' || operators.peek() == '-') && cur == '*')  {
          operators.push(cur);
        } else {
          while (!operators.isEmpty() && !((operators.peek() == '+' || operators.peek() == '-') && cur == '*')) {
            operands.push(op(operators.pop(), operands.pop(), operands.pop()));
          }

          operators.push(cur);
        }
      }
    }

    while (!operators.isEmpty()) {
      operands.push(op(operators.pop(), operands.pop(), operands.pop()));
    }

    return operands.pop();
  }

  private long op(char operator, long a, long b) {
    if (operator == '+') {
      return b + a;
    } else if (operator == '-') {
      return b - a;
    } else {
      return b * a;
    }
  }
}