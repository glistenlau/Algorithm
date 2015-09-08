/**
 * Set Matrix Zeros
 * www.lintcode.com/en/problem/set-matrix-zeros/
 *
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
 */
public class Solution {
  /**
   * @param matrix: A list of lists of integers
   * @return: Void
   */
  public void setZeroes(int[][] matrix) {
    // write your code here
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return;
    }

    boolean firstRow = false;
    boolean firstCol = false;

    for (int i = 0; i < matrix.length; i++) {
      if (matrix[i][0] == 0) {
        firstCol = true;
        break;
      }
    }

    for (int j = 0; j < matrix[0].length; j++) {
      if (matrix[0][j] == 0) {
        firstRow = true;
        break;
      }
    }

    for (int i = 1; i < matrix.length; i++) {
      for (int j = 1; j < matrix[0].length; j++) {
        if (matrix[i][j] == 0) {
          matrix[i][0] = 0;
          matrix[0][j] = 0;
        }
      }
    }

    for (int i = 1; i < matrix.length; i++) {
      for (int j = 1; j < matrix[0].length; j++) {
        if (matrix[i][0] == 0 || matrix[0][j] == 0) {
          matrix[i][j] = 0;
        }
      }
    }

    if (firstRow) {
      for (int j = 0; j < matrix[0].length; j++) {
        matrix[0][j] = 0;
      }
    }

    if (firstCol) {
      for (int i = 0; i < matrix.length; i++) {
        matrix[i][0] = 0;
      }
    }
  }
}
