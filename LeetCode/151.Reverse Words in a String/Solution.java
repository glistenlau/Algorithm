public class Solution {
  public String reverseWords(String s) {
    if (s == null || s.length() == 0) {
      return "";
    }
    StringBuilder sb = new StringBuilder();
    char[] chars = s.toCharArray();
    int left = 0;

    while (left < chars.length) {
      while (left < chars.length && chars[left] == ' ') {
        left++;
      }

      int right = left;
      while (right < chars.length && chars[right] != ' ') {
        right++;
      }
      if (sb.length() != 0 && left != right) {
        sb.insert(0, ' ');
      }
      sb.insert(0, chars, left, right - left);
      left = right + 1;
    }
    return sb.toString();
  }
}