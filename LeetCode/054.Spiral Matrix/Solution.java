public class Solution {
  public List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> result = new ArrayList<Integer>();
    if (matrix == null || matrix.length == 0) {
      return result;
    }

    int left = 0;
    int right = matrix[0].length - 1;
    int top = 0;
    int bottom = matrix.length - 1;

    while (left <= right && top <= bottom) {
      for (int i = left; i <= right; i++) {
        result.add(matrix[top][i]);
      }

      for (int i = top + 1; i <= bottom; i++) {
        result.add(matrix[i][right]);
      }

      if (top == bottom || left == right) {
        break;
      }

      for (int i = right - 1; i >= left; i--) {
        result.add(matrix[bottom][i]);
      }

      for (int i = bottom - 1; i > top; i--) {
        result.add(matrix[i][left]);
      }

      left++;
      right--;
      top++;
      bottom--;
    }
    return result;
  }
}