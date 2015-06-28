/**
 * Unique Paths
 * http://www.lintcode.com/en/problem/unique-paths/
 *
 * A robot is located at the top-left corner of a m x n grid (marked 'Start'
 * in the diagram below). The robot can only move either down or right at any
 * point in time. The robot is trying to reach the bottom-right corner of the
 * grid (marked 'Finish' in the diagram below). How many possible unique
 * paths are there?
 */
public class Solution {
  /**
   * @param n, m: positive integer (1 <= n ,m <= 100)
   * @return an integer
   */
  public int uniquePaths(int m, int n) {
    // write your code here
    if (m == 0 || n == 0) {
      return 0;
    }
    int[][] A = new int[m][n];
    for (int i = 0; i < m; i++) {
      A[i][0] = 1;
    }
    for (int j = 0; j < n; j++) {
      A[0][j] = 1;
    }
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        A[i][j] = A[i - 1][j] + A[i][j - 1];
      }
    }
    return A[m - 1][n - 1];
  }
}

