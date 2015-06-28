/**
 * Unique Paths II
 * http://www.lintcode.com/en/problem/unique-paths-ii/
 *
 * Follow up for "Unique Paths":
 *
 * Now consider if some obstacles are added to the grids. How many unique
 * paths would there be?
 *
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 *
 * Example
 * For example,
 * There is one obstacle in the middle of a 3x3 grid as illustrated below.
 * [
 *  [0,0,0],
 *  [0,1,0],
 *  [0,0,0]
 * ]
 * The total number of unique paths is 2.
 */
public class Solution {
  /**
   * @param obstacleGrid: A list of lists of integers
   * @return: An integer
   */
  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    //write your code here
    int m = obstacleGrid.length;
    if (m == 0) {
      return 0;
    }
    int n = obstacleGrid[0].length;

    int[][] A = new int[m][n];
    A[0][0] = 1;
    for (int i = 0; i < m; i++) {
      if (obstacleGrid[i][0] == 0) {
        A[i][0] = 1;
      } else {
        break;
      }
    }
    for (int j = 0; j < n; j++) {
      if (obstacleGrid[0][j] == 0) {
        A[0][j] = 1;
      } else {
        break;
      }
    }
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        if (obstacleGrid[i][j] == 0) {
          A[i][j] = A[i - 1][j] + A[i][j - 1];
        } else {
          A[i][j] = 0;
        }
      }
    }
    return A[m - 1][n - 1];
  }
}
