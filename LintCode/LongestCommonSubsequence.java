/**
 * Longest Common Subsequence
 * http://www.lintcode.com/en/problem/longest-common-subsequence/
 *
 * Given two strings, find the longest common subsequence (LCS).
 *
 * Your code should return the length of LCS.
 *
 * Example
 * For "ABCD" and "EDCA", the LCS is "A" (or "D", "C"), return 1.
 * For "ABCD" and "EACB", the LCS is "AC", return 2.
 */
public class Solution {
 /**
  * @param A, B: Two strings.
  * @return: The length of longest common subsequence of A and B.
  */
 public int longestCommonSubsequence(String A, String B) {
  // write your code here
  if (A.length() == 0 || B.length() == 0) {
   return 0;
  }
  int[][] count = new int[A.length() + 1][B.length() + 1];
  for (int i = 1; i <= A.length(); i++) {
   for (int j = 1; j <= B.length(); j++) {
    if (A.charAt(i - 1) == B.charAt(j - 1)) {
     count[i][j] = count[i - 1][j - 1] + 1;
    } else {
     count[i][j] = Math.max(count[i][j - 1], count[i - 1][j]);
    }
   }
  }
  return count[A.length()][B.length()];
 }
}


