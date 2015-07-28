public class Solution {
  public int minDistance(String word1, String word2) {
    int m = word1.length();
    int n = word2.length();
    int[][] minEdit = new int[m + 1][n + 1];

    for (int i = 1; i <= m; i++) {
      minEdit[i][0] = i;
    }
    for (int j = 1; j <= n; j++) {
      minEdit[0][j] = j;
    }

    for (int i = 1; i <= m; i++) {

      for (int j = 1; j <= n; j++) {
        if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
          minEdit[i][j] = Math.min(minEdit[i - 1][j - 1], minEdit[i - 1][j] + 1);
        } else {
          minEdit[i][j] = Math.min(minEdit[i][j - 1], Math.min(minEdit[i - 1][j - 1], minEdit[i - 1][j])) + 1;
        }
      }

    }

    return minEdit[m][n];
  }
}