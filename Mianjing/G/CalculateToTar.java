import java.util.Stack;

/**
 * write a function to add operator() to a string so it equals to a target value
 * for example
 * 123, 6 -> 1 + 2 + 3
 * 12345, 27 -> 1 + 2 * 3 + 4 * 5
 *
 * 思路是dfs加运算符号， 然后把加完符号的字符串运算看结果等于目标吗，如果等于就输出。
 */
public class CalculateToTar {
  public String calculateToSum(String str, int tar) {
    if (str == null || str.length() == 0) {
      return "";
    }

    StringBuilder ans = new StringBuilder(str);
    return dfsHelper(ans, 1, tar);

  }

  private String dfsHelper(StringBuilder ans, int pos, int tar) {
    if (pos >= ans.length()) {
      if (calculate(ans.toString()) == tar) {
        return ans.toString();
      }
      return null;
    }

    char[] operator = {'+', '-', '*', '/'};

    for (int i = 0; pos + i < ans.length(); i++) {
      for (int j = 0; j < 4; j++) {
        ans.insert(pos + i, operator[j]);
        String temp = dfsHelper(ans, pos + i + 2, tar);
        if (temp != null) {
          return temp;
        }
        ans.deleteCharAt(pos + i);
      }
    }

    return null;
  }

  private long calculate(String e) {
    Stack<Character> operator = new Stack<>();
    Stack<Long> operands = new Stack<>();

    int[] pri = new int[128];
    pri['+'] = 1;
    pri['-'] = 1;
    pri['*'] = 2;
    pri['/'] = 2;

    for (int i = 0; i < e.length(); i++) {
      char c = e.charAt(i);
      if (Character.isDigit(c)) {
        int right = i + 1;
        while (right < e.length() && Character.isDigit(e.charAt(right))) {
          right++;
        }
        operands.push(Long.parseLong(e.substring(i, right)));
        i = right - 1;
      } else {
        if (!operator.isEmpty() && ((pri[c] < pri[operator.peek()]) || (pri[c] == pri[operator
            .peek()] && pri[c] == 2))) {
          operands.push(op(operands.pop(), operands.pop(), operator.pop()));
        }

        operator.push(c);
      }
    }

    while (!operator.isEmpty()) {
      operands.push(op(operands.pop(), operands.pop(), operator.pop()));
    }

    return operands.pop();
  }

  private long op(long a, long b, Character operator) {
    long result = 0L;
    if (operator == '+') {
      result =  b + a;
    } else if (operator == '-') {
      result =  b - a;
    } else if (operator == '*') {
      result =  b * a;
    } else if (operator == '/') {
      if (a == 0) {
        result =  Long.MAX_VALUE;
      }
      result =  b / a;
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println(new CalculateToTar().calculateToSum("12345", 36));
  }
}
