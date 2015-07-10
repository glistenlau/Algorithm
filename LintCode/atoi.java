/**
 * String to Integer(atoi)
 * www.lintcode.com/en/problem/string-to-integeratoi/
 *
 * Implement function atoi to convert a string to an integer.
 *
 * If no valid conversion could be performed, a zero value is returned.
 *
 * If the correct value is out the range of representable values, INT_MAX
 * (2147483647) or INT_MIN(-2147483648) is returned.
 *
 * Example
 * "10" => 10
 * "-1" => -1
 * "12312312312313" => 2147483647
 * "1.0" => 1
 */


public class Solution {
  /**
   * @param str: A string
   * @return An integer
   */
  public int atoi(String str) {
    if (str == null || str.length() == 0) {
      return 0;
    }
    int result = 0;
    boolean pos = true;
    int index = 0;
    while(str.charAt(index) == ' ') {
      index++;
    }
    if (str.charAt(index) == '-' || str.charAt(index) == '+') {
      pos = str.charAt(index) == '-' ? false : true;
      index++;
      if (index < str.length() && !Character.isDigit(str.charAt(index))) {
        return 0;
      }
    } else if (str.charAt(index) < '0' || str.charAt(index) > '9') {
      return 0;
    }

    for (int i = index; i < str.length() ; i++) {
      if (pos && (result > 214748364 || (result == 214748364 && str.charAt(i) > '7'))) {
        return Integer.MAX_VALUE;
      } else if (!pos && (result > 214748364 || (result == 214748364 && str.charAt(i) > '8'))) {
        return Integer.MIN_VALUE;
      }

      if (Character.isDigit(str.charAt(i))) {
        result *= 10;
        result += Character.getNumericValue(str.charAt(i));
      } else {
        if (str.charAt(i) == '.') {
          break;
        } else if(str.charAt(i) == ' ') {
          i++;
          while (i < str.length() && str.charAt(i++) == ' ');
          if (i == str.length()) {
            break;
          } else {
            return 0;
          }
        } else {
          break;
        }
      }
    }
    if (!pos) {
      result = -result;
    }
    return result;
  }
}
