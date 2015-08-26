public class Solution {
  public String shortestPalindrome(String s) {
    if (s == null || s.length() == 0) {
      return "";
    }

    int tail = getLongestPrefix(s);
    StringBuilder ans = new StringBuilder();
    for (int i = s.length() - 1; i >= tail; i--) {
      ans.append(s.charAt(i));
    }
    ans.append(s);
    return ans.toString();
  }

  private char getCharacter(String s, int index) {
    if (index == 0) {
      return '^';
    }
    if (index == 2 * s.length() + 2) {
      return '$';
    }
    if (index % 2 != 0) {
      return '#';
    }
    return s.charAt((index - 1) / 2);
  }

  private int getLongestPrefix(String s) {
    int[] p = new int[2 * s.length() + 3];
    int id = 0;
    int mx = 0;
    for (int i = 1; i < 2 * s.length() + 2; i++) {
      p[i] = mx > i? Math.min(p[2 * id - i], mx - i): 0;

      while (getCharacter(s, i + 1 + p[i]) == getCharacter(s, i - 1 - p[i])) {
        p[i]++;
      }

      if (p[i] + i > mx) {
        id = i;
        mx = p[i] + i;
      }
    }

    int maxLen = 0;
    int center = 0;
    for (int i = 1; i < 2 * s.length() + 2; i++) {
      if (i - p[i] <= 2 && p[i] > maxLen) {
        center = i;
        maxLen = p[i];
      }
    }

    return maxLen;
  }
}