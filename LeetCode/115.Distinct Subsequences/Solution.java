public class Solution {
  public int numDistinct(String s, String t) {
    int[][] numsSub = new int[s.length() + 1][t.length() + 1];

    for (int i = 0; i <= s.length(); i++) {
      numsSub[i][0] = 1;
    }

    for (int i = 1; i <= s.length(); i++) {
      for (int j = 1; j <= t.length(); j++) {
        numsSub[i][j] = numsSub[i - 1][j];
        if (s.charAt(i - 1) == t.charAt(j - 1)) {
          numsSub[i][j] += numsSub[i - 1][j - 1];
        }
      }
    }

    return numsSub[s.length()][t.length()];
  }
}