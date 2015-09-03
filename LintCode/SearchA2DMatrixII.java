/**
 * Search a 2D Matrix II
 * www.lintcode.com/en/problem/search-a-2d-matrix-ii/
 *
 * Write an effcient algorithm that searches for a value in an m x n matrix, return
 * the occurrence of it.
 *
 * This matrix has the following preperties:
 *   * Integers in each row are sorted from left to right.
 *   * Integers in each column are sorted form up to bottom.
 *   * No duplicate integers in each row or column.
 *
 * Example
 * [
 *   [1, 3, 5, 7],
 *   [2, 4, 7, 8],
 *   [3, 5, 9, 10]
 * ]
 */
public class Solution {
  /**
   * @param matrix: A list of lists of integers
   * @param: A number you want to search in the matrix
   * @return: An integer indicate the occurrence of target in the given matrix
   */
  public int searchMatrix(int[][] matrix, int target) {
    // write your code here
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return 0;
    }

    int count = 0;
    int row = 0;
    int col = matrix[0].length - 1;

    while (row < matrix.length && col >= 0) {
      if (matrix[row][col] == target) {
        count++;
        row++;
      } else if (matrix[row][col] > target) {
        col--;
      } else {
        row++;
      }
    }

    return count;
  }
}

