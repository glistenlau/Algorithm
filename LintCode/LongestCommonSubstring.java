/**
 * Longest Common Substring
 * http://www.lintcode.com/en/problem/longest-common-substring/
 *
 * Given two strings, find the longest common substring.
 *
 * Return the length of it.
 *
 * Example
 *
 * Given A = "ABCD", B = "CBCE", return 2.
 */
public class Solution {
  /**
   * @param A, B: Two string.
   * @return: the length of the longest common substring.
   */
  public int longestCommonSubstring(String A, String B) {
    // write your code here
    if (A.length() == 0 || B.length() == 0) {
      return 0;
    }
    int[][] count = new int[A.length() + 1][B.length() + 1];
    int max = 0;
    for (int i = 1; i <= A.length(); i++) {
      for (int j = 1; j <= B.length(); j++) {
        if (A.charAt(i - 1) == B.charAt(j - 1)) {
          count[i][j] = count[i - 1][j - 1] + 1;
          if (count[i][j] > max) {
            max = count[i][j];
          }
        }
      }
    }
    return max;
  }
}
