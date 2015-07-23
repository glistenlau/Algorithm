public class Solution {
  public boolean isMatch(String s, String p) {
    boolean[][] isMatch = new boolean[p.length() + 1][s.length() + 1];

    isMatch[0][0] = true;
    for (int i = 1; i <= p.length(); i++) {
      isMatch[i][0] = isMatch[i - 1][0] && p.charAt(i - 1) == '*';
    }

    for (int i = 1; i <= p.length(); i++) {
      for (int j = 1; j <= s.length(); j++) {
        if (p.charAt(i - 1) != '*') {
          isMatch[i][j] = isMatch[i - 1][j - 1] && (p.charAt(i - 1) == s.charAt(j - 1) || p.charAt(i - 1) == '?');
        } else {
          isMatch[i][j] = isMatch[i - 1][j] || isMatch[i][j - 1];
        }
      }
    }

    return isMatch[p.length()][s.length()];
  }
}