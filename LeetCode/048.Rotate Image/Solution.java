public class Solution {
  public void rotate(int[][] matrix) {
    if (matrix == null || matrix.length == 0) {
      return;
    }
    int n = matrix.length;

    for (int level = 0; level < n / 2; level++) {
      for (int i = level; i < n - 1 - level; i++) {
        int temp = matrix[level][i];
        matrix[level][i] = matrix[n - 1 - i][level];
        matrix[n - 1 - i][level] = matrix[n - 1 - level][n - 1 - i];
        matrix[n - 1 - level][n - 1 - i] = matrix[i][n - 1 - level];
        matrix[i][n - 1 - level] = temp;
      }
    }
  }
}