/**
 * Minimum Path Sum
 * http://www.lintcode.com/en/problem/minimum-path-sum/
 *
 * Given a m x n grid filled with non-negative numbers, find a path from top
 * left to bottom right which minimizes the sum of all numbers along its path.
 */
public class Solution {
  /**
   * @param grid: a list of lists of integers.
   * @return: An integer, minimizes the sum of all numbers along its path
   */
  public int minPathSum(int[][] grid) {
    // write your code here
    int m = grid.length;
    if (m == 0) {
      return 0;
    }
    int n = grid[0].length;
    int[][] A = new int[m][n];
    A[0][0] = grid[0][0];

    for (int i = 1; i < n; i++) {
      A[0][i] = A[0][i - 1] + grid[0][i];
    }
    for (int j = 1; j < m; j++) {
      A[j][0] = A[j - 1][0] + grid[j][0];
    }

    int min = Integer.MAX_VALUE;
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        A[i][j] = Math.min(A[i - 1][j], A[i][j - 1]) + grid[i][j];
      }
    }
    return A[m - 1][n - 1];
  }
}

