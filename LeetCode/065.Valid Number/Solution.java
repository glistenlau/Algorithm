public class Solution {
  public boolean isNumber(String s) {
    if (s == null || s.length() == 0) {
      return false;
    }
    int n = s.length();
    int left = 0;
    int right = n - 1;

    while(left < right && s.charAt(left) == ' ') {
      left++;
    }
    while(left < right && s.charAt(right) == ' ') {
      right--;
    }

    if(s.charAt(left) == '+' || s.charAt(left) == '-') {
      left++;
    }

    boolean num = false;
    boolean dot = false;
    boolean exp = false;

    for (int i = left; i <= right; i++) {
      char c = s.charAt(i);
      if (Character.isDigit(c)) {
        num = true;
      } else if (c == '.') {
        if (exp || dot) {
          return false;
        } else {
          dot = true;
        }
      } else if (c == 'e') {
        if (!num || exp) {
          return false;
        }
        num = false;
        exp = true;
      } else if (c == '+' || c == '-') {
        if (num || s.charAt(i - 1) != 'e') {
          return false;
        }
      } else {
        return false;
      }
    }

    return num;
  }
}