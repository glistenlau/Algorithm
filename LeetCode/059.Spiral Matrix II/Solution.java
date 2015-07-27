public class Solution {
  public int[][] generateMatrix(int n) {
    int[][] result = new int[n][n];
    int left = 0;
    int right = n - 1;
    int top = 0;
    int bottom = n - 1;
    int count = 1;

    while(left <= right && top <= bottom) {
      for (int i = left; i <= right; i++) {
        result[top][i] = count++;
      }
      for (int i = top + 1; i <= bottom; i++) {
        result[i][right] = count++;
      }

      if (left == right || top == bottom) {
        break;
      }

      for (int i = right - 1; i >= left; i--) {
        result[bottom][i] = count++;
      }
      for (int i = bottom - 1; i > top; i--) {
        result[i][left] = count++;
      }

      left++;
      right--;
      top++;
      bottom--;
    }
    return result;
  }
}