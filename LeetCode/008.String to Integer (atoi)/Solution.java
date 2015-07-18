public class Solution {
  public int myAtoi(String str) {
    if (str == null || str.length() == 0) {
      return 0;
    }

    boolean pos = true;
    int i = 0;
    int result = 0;

    while (i < str.length() && str.charAt(i) == ' ') {
      i++;
    }
    if (i < str.length() && !Character.isDigit(str.charAt(i))) {
      if (str.charAt(i) == '-' || str.charAt(i) == '+') {
        if (str.charAt(i) == '-') {
          pos = false;
        }
        i++;
      } else {
        return 0;
      }
    }

    while (i < str.length() && Character.isDigit(str.charAt(i))) {
      int digit = Character.getNumericValue(str.charAt(i));
      if (result > Integer.MAX_VALUE / 10 || result == Integer.MAX_VALUE / 10 && digit > 7) {
        return pos ? Integer.MAX_VALUE : Integer.MIN_VALUE;
      }
      result *= 10;
      result += Character.getNumericValue(str.charAt(i));
      i++;
    }

    return pos ? result : -result;
  }
}