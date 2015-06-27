/**
 * Triangle
 * http://www.lintcode.com/en/problem/triangle/
 *
 * Given a triangle, find the minimum path sum from top to bottom. Each step
 * you may move to adjacent numbers on the row below.
 *
 * Example
 * For example, given the following triangle
 * [
 *  [2],
 *  [3,4],
 *  [6,5,7],
 *  [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 */
public class Solution {
  /**
   * @param triangle: a list of lists of integers.
   * @return: An integer, minimum path sum.
   */
  public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
    // write your code here
    int m = triangle.size();
    int n = triangle.get(m - 1).size();
    int[][] A = new int[m][n];
    A[0][0] = triangle.get(0).get(0);
    for (int i = 1; i < m; i++) {
      for (int j = 0; j < i + 1; j++) {
        if (j == 0) {
          A[i][j] = A[i - 1][j] + triangle.get(i).get(j);
        } else if (j > 0 && j < i) {
          A[i][j] = Math.min(A[i - 1][j], A[i - 1][j - 1]) + triangle.get(i).get(j);
        } else {
          A[i][j] = A[i - 1][j - 1] + triangle.get(i).get(j);
        }
      }
    }
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < m; i++) {
      min = Math.min(min, A[m - 1][i]);
    }
    return min;
  }
}