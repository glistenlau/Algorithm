/**
 * 问一个二维数组表示的n*n的矩阵，找出一条连续的最长的路径的长度。
 * 比如
 * 7 8 6
 * 9 4 5
 * 2 3 1
 * 最长是2,3,4,5,6，返回长度5.
 *
 * lintcode 上有这题， http://www.lintcode.com/en/problem/longest-increasing-continuous-subsequence-ii/
 * 思路就是把每个点作为最大点， 找比自己小的有多少个， 然后用memorizing search来去除重复的遍历。
 */
public class Ski {
  public int Ski(int[][] matrix) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return 0;
    }

    int[][] dp = new int[matrix.length][matrix[0].length];
    boolean[][] visited = new boolean[matrix.length][matrix[0].length];
    int max = 0;

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix.length; j++) {
        max = Math.max(max, search(matrix, i, j, dp, visited));
      }
    }

    return max;
  }

  private int search(int[][] matrix, int row, int col, int[][] dp, boolean[][] visited) {
    if (visited[row][col]) {
      return dp[row][col];
    }

    visited[row][col] = true;
    dp[row][col] = 1;

    int[] dx = {0, 0, -1, 1};
    int[] dy = {1, -1, 0, 0};

    for (int i = 0; i < 4; i++) {
      int r = row + dx[i];
      int c = col + dy[i];

      if (r >= 0 && r < matrix.length && c >= 0 && c < matrix[0].length) {
        if (matrix[r][c] < matrix[row][col]) {
          dp[row][col] = Math.max(dp[row][col], search(matrix, r, c, dp, visited) + 1);
        }
      }
    }

    return dp[row][col];
  }
}
