public class Solution {
  public String addBinary(String a, String b) {
    if (a == null || a.length() == 0) {
      return b;
    }
    if (b == null || b.length() == 0) {
      return a;
    }

    int m = a.length() - 1;
    int n = b.length() - 1;
    int sum = 0;
    int carry = 0;

    StringBuilder result = new StringBuilder();
    while (m >= 0 || n >= 0) {
      int num1 = m < 0? 0: a.charAt(m) - '0';
      int num2 = n < 0? 0: b.charAt(n) - '0';
      sum = num1 + num2 + carry;
      result.append(sum % 2);
      carry = sum / 2;
      m--;
      n--;
    }

    if (carry != 0) {
      result.append(carry);
    }

    result.reverse();
    return result.toString();
  }
}