public class Solution {
  public String multiply(String num1, String num2) {
    if (num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0) {
      return "0";
    }
    if (num1.equals("0") || num2.equals("0")) {
      return "0";
    }
    StringBuilder sb = new StringBuilder();
    int n = num1.length() + num2.length() - 2;;
    int carry = 0;
    int sum;

    for (int i = n; i >= 0; i--) {
      sum = carry;

      for(int i1 = 0; i1 < num1.length(); i1++) {
        int i2 = i - i1;
        if (i2 >= 0 && i2 < num2.length()) {
          sum += Character.getNumericValue(num1.charAt(i1)) * Character.getNumericValue(num2.charAt(i2));
        }
      }

      carry = sum / 10;
      sum %= 10;
      sb.insert(0, sum);
    }

    while (carry != 0) {
      sum = carry % 10;
      carry /= 10;
      sb.insert(0, sum);
    }

    return sb.toString();
  }
}