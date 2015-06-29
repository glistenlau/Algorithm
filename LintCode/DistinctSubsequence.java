/**
 * Distinct Subsequence
 * http://www.lintcode.com/en/problem/distinct-subsequences/
 *
 * Given a string S and string T, count the number of distinct subsequences
 * of T in S.
 *
 * A subsequence of a string is a new string which is formed form the
 * original string by deleting some (can be none) of the characters without
 * disturbing the relative positions of the remainning characters. (ie, "ACE"
 * is a subsequence of "ABCDE" while "AEC" is not).
 *
 * Example
 * Given S = "rabbbit", T = "rabbit", return 3.
 */
public class Solution {
  /**
   * @param S, T: Two string.
   * @return: Count the number of distinct subsequences
   */
  public int numDistinct(String S, String T) {
    // write your code here
    if (S == null || T == null) {
      return -1;
    }
    int[][] diffSub = new int[S.length() + 1][T.length() + 1];
    for (int i = 0; i <= S.length(); i++) {
      diffSub[i][0] = 1;
    }
    for (int i = 1; i <= S.length(); i++) {
      for (int j = 1; j <= T.length(); j++) {
        if (S.charAt(i - 1) == T.charAt(j - 1)) {
          diffSub[i][j] = diffSub[i - 1][j - 1] + diffSub[i - 1][j];
        } else {
          diffSub[i][j] = diffSub[i - 1][j];
        }
      }
    }
    return diffSub[S.length()][T.length()];
  }
}
