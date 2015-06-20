/**
 * Created by YiLIU on 6/19/15.
 */
public class SearchA2DMatrix {
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
