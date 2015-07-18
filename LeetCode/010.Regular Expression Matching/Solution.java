public class Solution {
  public boolean isMatch(String s, String p) {
    if (s == null || p == null) {
      return false;
    }

    boolean[][] lookup = new boolean[s.length() + 1][p.length() + 1];
    lookup[0][0] = true;
    for (int i = 1; i <= p.length(); i++) {
      lookup[0][i] = p.charAt(i - 1) == '*' && lookup[0][i - 2];
    }
    for (int j = 1; j <= s.length(); j++) {
      lookup[j][0] = false;
    }

    for (int i = 1; i <= p.length(); i++) {
      boolean star = p.charAt(i - 1) == '*' ? true : false;
      for (int j = 1 ; j <= s.length(); j++) {
        if(star) {
          lookup[j][i] = lookup[j][i - 2] || (lookup[j - 1][i] && (s.charAt(j - 1) == p.charAt(i - 2) || p.charAt(i - 2) == '.'));
        }
        else {
          lookup[j][i] = lookup[j - 1][i - 1] && (s.charAt(j - 1) == p.charAt(i - 1) || p.charAt(i - 1) == '.');
        }
      }
    }

    return lookup[s.length()][p.length()];
  }
}