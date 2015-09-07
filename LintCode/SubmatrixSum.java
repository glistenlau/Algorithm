/**
 * Submatrix Sum
 * www.lintcode.com/en/problem/submatrix-sum/
 *
 * Given an integer matrix, find a submatrix where the sum of numbers is zero. Your code
 * should return the coordinate of the left-up and right-down number.
 *
 * Example
 * Given matrix
 * [
 *   [1, 5, 7],
 *   [3, 7, -8],
 *   [4, -8, 9],
 * ]
 *
 * return [(1, 1), (2, 2)]
 */
public class Solution {
  /**
   * @param matrix an integer matrix
   * @return the coordinate of the left-up and right-down number
   */
  public int[][] submatrixSum(int[][] matrix) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return new int[0][0];
    }

    int[][] sums = new int[matrix.length + 1][matrix[0].length + 1];
    for (int i = 1; i <= matrix.length; i++) {
      for (int j = 1; j <= matrix[0].length; j++) {
        sums[i][j] = sums[i - 1][j] + sums[i][j - 1] - sums[i - 1][j - 1] + matrix[i - 1][j - 1];
      }
    }

    for (int i = 1; i <= matrix.length; i++) {
      for (int j = i; j <= matrix.length; j++) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        for (int k = 1; k <= matrix[0].length; k++) {
          int sum = sums[j][k] - sums[i - 1][k];
          if (map.containsKey(sum)) {
            int pre = map.get(sum);
            return new int[][] {{i - 1, pre}, {j - 1, k - 1}};
          }
          map.put(sum, k);
        }
      }
    }

    return new int[0][0];
  }
}
