/**
 * Valid Number
 * www.lintcode.com/en/problem/valid-number/
 *
 * Validate if a given string is numeric.
 */
public class Solution {
  /**
   * @param s the string that represents a number
   * @return whether the string is a valid number
   */
  public boolean isNumber(String s) {
    // Write your code here
    if (s == null || s.length() == 0) {
      return false;
    }
    String[] nums = s.split("e");
    if (nums.length > 2 || nums.length == 0) {
      return false;
    }

    if (nums.length == 1) {
      return isNumber(nums[0], false);
    } else {
      return isNumber(nums[0], false) && isNumber(nums[1], true);
    }
  }

  private boolean isNumber(String s, boolean hasE) {
    if (s.length() == 0) {
      return false;
    }
    boolean dot = false;
    boolean num = false;

    int left = 0;
    while (left < s.length() && s.charAt(left) == ' ') {
      left++;
    }
    int right = s.length() - 1;
    while (right >= 0 && s.charAt(right) == ' ') {
      right --;
    }

    if (left > right) {
      return false;
    }
    if (s.charAt(left) == '+' || s.charAt(left) == '-') {
      left++;
    }

    while (left <= right) {
      if (!Character.isDigit(s.charAt(left))) {
        if (s.charAt(left) == '.') {
          if (dot || hasE) {
            return false;
          }
          dot = true;
          num = false;
        } else {
          return false;
        }
      } else {
        num = true;
      }
      left++;
    }

    return num;
  }
}
