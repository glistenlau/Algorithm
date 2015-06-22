/**
 * Search a 2D Matrix
 * http://www.lintcode.com/en/problem/search-a-2d-matrix/
 *
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 *   *Integers in each row are sorted from left to right.
 *   *The first integer of each row is greater than the last integer of the
 *   previous row.
 *
 * Example
 * Consider the following matrix:
 * [
 * [1, 3, 5, 7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 *
 * Given target = 3, return true.
 */
public class Solution {
  /**
   * @param matrix, a list of lists of integers
   * @param target, an integer
   * @return a boolean, indicate whether matrix contains target
   */
  public boolean searchMatrix(int[][] matrix, int target) {
    if (matrix.length == 0) {
      return false;
    }
    int left = 0;
    int right = matrix.length - 1;
    int row = -1;
    while (left + 1 < right) {
      int mid = left + (right - left) / 2;
      if (matrix[mid][0] > target) {
        right = mid;
      } else {
        left = mid;
      }
    }
    if (matrix[right][0] <= target) {
      row = right;
    } else {
      row = left;
    }
    left = 0;
    right = matrix[row].length - 1;
    while (left + 1 < right) {
      int mid = left + (right - left) / 2;
      if (matrix[row][mid] == target) {
        return true;
      } else if (matrix[row][mid] < target) {
        left = mid;
      } else {
        right = mid;
      }
    }

    if (matrix[row][left] == target || matrix[row][right] == target) {
      return true;
    } else {
      return false;
    }
  }
}