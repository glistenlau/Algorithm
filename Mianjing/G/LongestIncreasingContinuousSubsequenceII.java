/**
 * Created by YiLIU on 9/2/15.
 */
public class LongestIncreasingContinuousSubsequenceII {
  public int longestIncreasingContinuousSubsequenceII(int[][] A) {
    // Write your code here
    if(A == null || A.length == 0 || A[0].length == 0) {
      return 0;
    }

    int dp[][] = new int[A.length][A[0].length];
    boolean visited[][] = new boolean[A.length][A[0].length];
    int max = 1;

    for (int r = 0; r < A.length; r++) {
      for (int c = 0; c < A[0].length; c++) {
        if (!visited[r][c]) {
          max = Math.max(max, search(A, r, c, dp, visited));
        }
      }
    }

    return max;
  }

  private int search(int[][] A, int r, int c, int[][] dp, boolean[][] visited) {
    if (visited[r][c]) {
      return dp[r][c];
    }
    dp[r][c] = 1;
    visited[r][c] = true;
    int[] dx = {0, 0, -1, 1};
    int[] dy = {1, -1, 0, 0};

    for (int i = 0; i < 4; i++) {
      int row = r + dx[i];
      int col = c + dy[i];
      if (row >= 0 && row < A.length && col >= 0 && col < A[0].length) {
        if (A[row][col] < A[r][c]) {
          dp[r][c] = Math.max(dp[r][c], search(A, row, col, dp, visited) + 1);
        }
      }
    }

    return dp[r][c];
  }


  public static void main(String[] args) {
    int[][] A = {
        {1 ,2 ,3 ,4 ,5},
        {16,17,24,23,6},
        {15,18,25,22,7},
        {14,19,20,21,8},
        {13,12,11,10,9},
    };
    LongestIncreasingContinuousSubsequenceII test = new LongestIncreasingContinuousSubsequenceII();
    test.longestIncreasingContinuousSubsequenceII(A);
  }
}
