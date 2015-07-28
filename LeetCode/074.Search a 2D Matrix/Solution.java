public class Solution {
  public boolean searchMatrix(int[][] matrix, int target) {
    if (matrix == null || matrix.length == 0) {
      return false;
    }

    int n = matrix.length * matrix[0].length;
    int left = 0;
    int right = n - 1;

    while (left + 1 < right) {
      int mid = left + (right - left) / 2;
      int row = mid / matrix[0].length;
      int col = mid % matrix[0].length;
      if (matrix[row][col] == target) {
        return true;
      } else if (matrix[row][col] < target) {
        left = mid;
      } else {
        right = mid;
      }
    }

    if (matrix[left / matrix[0].length][left % matrix[0].length] == target) {
      return true;
    }

    if (matrix[right / matrix[0].length][right % matrix[0].length] == target) {
      return true;
    }

    return false;
  }
}