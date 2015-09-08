/**
 * Rotate Image
 * www.lintcode.com/en/problem/rotate-image/
 *
 * You are given an n x n 2D matrix representing an image. Rotate the image by 90 degrees(clockwise).
 */
public class Solution {
  /**
   * @param matrix: A list of lists of integers
   * @return: Void
   */
  public void rotate(int[][] matrix) {
    // write your code here
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return;
    }

    int l = 0;
    int r = matrix.length - 1;
    int t = 0;
    int b = matrix.length - 1;

    while (l < r && t < b) {
      for (int i = 0; i < r - l; i++) {
        int temp = matrix[t][l + i];
        matrix[t][l + i] = matrix[b - i][l];
        matrix[b - i][l] = matrix[b][r - i];
        matrix[b][r - i] = matrix[t + i][r];
        matrix[t + i][r] = temp;
      }
      l++;
      r--;
      t++;
      b--;
    }
  }
}
