public class Solution {
  public String longestPalindrome(String s) {
    String result = new String();
    if (s == null || s.length() == 0) {
      return result;
    }
    for (int i = 0; i < s.length(); i++) {
      int hLen = lenOfPalindrome(s, i);
      if (2 * hLen + 1 > result.length()) {
        result = s.substring(i - hLen, i + hLen + 1);
      }
    }
    return result;
  }

  private int lenOfPalindrome(String s, int i) {
    int len = 0;
    int left = i - 1;
    int right = i + 1;
    while (left >= 0 && right < s.length()) {
      if (s.charAt(left) != s.charAt(right)) {
        return len;
      }
      len += 1;
    }
    return len;
  }
}