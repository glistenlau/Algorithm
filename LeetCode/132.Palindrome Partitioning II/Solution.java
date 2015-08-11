public class Solution {
  public int minCut(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }

    int[] minCut = new int[s.length() + 1];
    boolean[][] isPal = getPal(s);
    for (int i = 0; i <= s.length(); i++) {
      minCut[i] = i - 1;
    }

    for (int i = 2; i <= s.length(); i++) {
      for (int j = 0; j < i; j++) {
        if (isPal[j][i - 1]) {
          minCut[i] = Math.min(minCut[j] + 1, minCut[i]);
        }
      }
    }

    return minCut[s.length()];
  }

  private boolean[][] getPal(String s) {
    boolean[][] isPal = new boolean[s.length()][s.length()];
    for (int i = 0; i < s.length(); i++) {
      isPal[i][i] = true;
    }

    for (int i = 1; i < s.length(); i++) {
      isPal[i - 1][i] = s.charAt(i - 1) == s.charAt(i);
    }

    for (int len = 2; len < s.length(); len++) {
      for (int start = 0; start + len < s.length(); start++) {
        isPal[start][start + len] = isPal[start + 1][start + len - 1] && s.charAt(start) == s.charAt(start + len);
      }
    }

    return isPal;
  }
}