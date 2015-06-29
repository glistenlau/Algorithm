/**
 * Edit Distance
 * http://www.lintcode.com/en/problem/edit-distance/
 *
 * Given two words word1 and word2, find the minimum number of steps required
 * to convert word1 to word2. (each operation is counted as 1 step.)
 *
 * You have the following 3 operateions permmited on a word:
 *   Insert a character
 *   Delete a character
 *   Replace a character
 *
 * Example
 * Given word1 = "mart" and word2 = "karma", return 3.
 */
public class Solution {
  /**
   * @param word1 & word2: Two string.
   * @return: The minimum number of steps.
   */
  public int minDistance(String word1, String word2) {
    // write your code here
    if (word1 == null || word2 == null) {
      return -1;
    }
    int[][] minD = new int[word1.length() + 1][word2.length() + 1];
    for (int i = 0; i <= word1.length(); i++) {
      minD[i][0] = i;
    }
    for (int j = 0; j <= word2.length(); j++) {
      minD[0][j] = j;
    }
    for (int i = 1; i <= word1.length(); i++) {
      for (int j = 1; j <= word2.length(); j++) {
        if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
          minD[i][j] = Math.min(minD[i - 1][j - 1], minD[i - 1][j] + 1);
          minD[i][j] = Math.min(minD[i][j], minD[i][j - 1] + 1);
        } else {
          minD[i][j] = Math.min(minD[i - 1][j], minD[i - 1][j - 1]);
          minD[i][j] = Math.min(minD[i][j], minD[i][j - 1]) + 1;
        }
      }
    }
    return minD[word1.length()][word2.length()];
  }
}
