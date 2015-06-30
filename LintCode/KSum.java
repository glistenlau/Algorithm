/**
 * K Sum
 * https://leetcode.com/problemset/algorithms/
 *
 * Given n distinct positive integers, integer k(k <= n) and a number target.
 *
 * Find k numbers where sum is target. Calculate how many solutions there are?
 *
 * Example
 * Given [1, 2, 3, 4], k = 2, target = 5.
 * There are 2 solutions: [1, 4] and [2, 3].
 * Return 2.
 */
public class Solution {
  /**
   * @param A: an integer array.
   * @param k: a positive integer (k <= length(A))
   * @param target: a integer
   * @return an integer
   */
  public int kSum(int A[], int k, int target) {
    // write your code here
    if (A == null || A.length == 0) {
      return 0;
    }
    int[][][] sol = new int[k + 1][A.length + 1][target + 1];
    for (int i = 0; i <= A.length; i++) {
      sol[0][i][0] = 1;
    }

    for (int i = 1; i <= k; i++) {
      for (int j = 1; j <= A.length; j++) {
        for (int o = 1; o <= target; o++) {
          if (A[j - 1] > o) {
            sol[i][j][o] = sol[i][j - 1][o];
            continue;
          }
          sol[i][j][o] += sol[i - 1][j - 1][o - A[j - 1]] + sol[i][j - 1][o];
        }
      }
    }
    return sol[k][A.length][target];
  }
}

