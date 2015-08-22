/**
 * Maximal Square
 * www.lintcode.com/en/problem/maximal-square/
 *
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing all 1's and return its area.
 *
 * Example
 * Given the following matrix:
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 *
 * Return 4.
 */
public class Solution {
  /**
   * @param matrix: a matrix of 0 and 1
   * @return: an integer
   */
  public int maxSquare(int[][] matrix) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return 0;
    }

    int[][] square = new int[matrix.length][matrix[0].length];
    int max = 0;

    for (int i = 0; i < matrix.length; i++) {
      square[i][0] = matrix[i][0] == 1? 1: 0;
      max = matrix[i][0] == 1? 1: max;
    }
    for (int j = 0; j < matrix[0].length; j++) {
      square[0][j] = matrix[0][j] == 1? 1: 0;
      max = matrix[0][j] == 1? 1: max;
    }


    for (int i = 1; i < matrix.length; i++) {
      for (int j = 1; j < matrix[0].length; j++) {
        if (matrix[i][j] == 1) {
          square[i][j] = Math.min(square[i - 1][j], Math.min(square[i][j - 1], square[i - 1][j - 1])) + 1;
          max = Math.max(max, square[i][j]);
        }
      }
    }

    return max * max;
  }
}

