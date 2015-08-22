/**
 * Longest Incresing Continuous Subsequence II
 * www.lintcode.com/en/problem/longest-continuous-subsequence-ii/
 *
 * Given you an integer matrix(with row size n, column size m), find the longest increasing continuous
 * subsequence in this matrix. (The definition of the longest increasing continuous subsequence here can
 * start at any row or column and go up/down/right/left any direction).
 */

public class Solution {
  /**
   * @param A an integer matrix
   * @return  an integer
   */
  public int longestIncreasingContinuousSubsequenceII(int[][] A) {
    if (A == null || A.length == 0|| A[0].length == 0) {
      return 0;
    }

    int max = 0;
    int[][] f = new int[A.length][A[0].length];
    boolean[][] found = new boolean[A.length][A[0].length];

    for (int i = 0; i < A.length; i++) {
      for (int j = 0; j < A[0].length; j++) {
        max = Math.max(max, dfs(A, i, j, f, found));
      }
    }

    return max;
  }

  private int dfs(int[][] A, int r, int c, int[][] f, boolean[][] found) {
    if (found[r][c]) {
      return f[r][c];
    }

    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    found[r][c] = true;
    f[r][c] = 1;

    for (int i = 0; i < 4; i++) {
      int row = r + dx[i];
      int col = c + dy[i];

      if (row >= 0 && row < A.length && col >= 0 && col < A[0].length) {
        if (A[row][col] < A[r][c]) {
          f[r][c] = Math.max(f[r][c], dfs(A, row, col, f, found) + 1);
        }
      }

    }

    return f[r][c];
  }
}
