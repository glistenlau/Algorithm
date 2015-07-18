public class Solution {
  public String convert(String s, int numRows) {
    if (s == null || s.length() <= numRows || numRows == 1) {
      return s;
    }

    int ln = 2 * numRows - 2;
    int left = 0;
    int right = ln;
    StringBuilder result = new StringBuilder();

    while (left <= right) {
      int n = 0;

      while (n * ln < s.length()) {
        if ((left == 0 || left == right) && n * ln + left < s.length()) {
          result.append(s.charAt(n * ln + left));
        } else {
          if (n * ln + left < s.length()) {
            result.append(s.charAt(n * ln + left));
          }
          if (n * ln + right < s.length()) {
            result.append(s.charAt(n * ln + right));
          }
        }
        n++;
      }

      left++;
      right--;
    }
    return result.toString();
  }
}