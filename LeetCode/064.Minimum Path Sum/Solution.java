public class Solution {
  public int minPathSum(int[][] grid) {
    if (grid == null || grid.length == 0) {
      return 0;
    }

    int m = grid.length;
    int n = grid[0].length;

    int[][] sums = new int[m][n];
    sums[0][0] = grid[0][0];

    for (int i = 0; i < m; i++) {

      for (int j = 0; j < n; j++) {
        if (i == 0 && j == 0) {
          continue;
        }

        int left = j > 0? sums[i][j - 1]: Integer.MAX_VALUE;
        int top = i > 0? sums[i - 1][j]: Integer.MAX_VALUE;
        sums[i][j] = Math.min(left, top) + grid[i][j];
      }

    }

    return sums[m - 1][n - 1];
  }
}