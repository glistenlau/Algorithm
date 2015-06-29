/**
 * Longest Increasing Continuous Subsequence
 * http://www.lintcode.com/en/problem/longest-increasing-continuous-subsequence/
 *
 * Give you an integer array (index from 0 to n-1, where n is the size of
 * this array), find the longest increasing continuous subsequence in this
 * array. (The definition of the longest increasing continuous subsequence
 * here can be from right to left or from left to right)
 *
 * Example
 * For[5, 4, 2, 1, 3], the LICS is [5, 4, 2, 1], return 4.
 * For[5, 1, 2, 3, 4], the LICS is [1, 2, 3, 4], return 4.
 */
public class Solution {
  /**
   * @param A an array of Integer
   * @return  an integer
   */
  public int longestIncreasingContinuousSubsequence(int[] A) {
    // Write your code here
    if(A == null || A.length == 0) {
      return 0;
    }
    boolean assending = false;
    int max = 0;
    int count = 1;
    for(int i = 1; i < A.length; i++) {
      if (A[i] < A[i - 1]) {
        if (!assending) {
          count++;
        } else {
          max = Math.max(count, max);
          assending = !assending;
          count = 2;
        }
      } else if (A[i] > A[i - 1]) {
        if (assending) {
          count++;
        } else {
          max = Math.max(count, max);
          assending = !assending;
          count = 2;
        }
      } else {
        count = 1;
      }
    }
    max = Math.max(count, max);
    return max;
  }
}
