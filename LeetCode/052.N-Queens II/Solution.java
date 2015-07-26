public class Solution {
  public int totalNQueens(int n) {
    boolean[] cols = new boolean[n];
    boolean[] main_diag = new boolean[n + n - 1];
    boolean[] anti_diag = new boolean[n + n - 1];

    return DFS(n, cols, main_diag, anti_diag, 0);
  }

  private int DFS(int n, boolean[] cols, boolean[] main_diag, boolean[] anti_diag, int row) {
    if (row == n) {
      return 1;
    }

    int count = 0;

    for (int i = 0; i < n; i++) {
      if (!cols[i] && !main_diag[i - row + n - 1] && !anti_diag[i + row]) {
        cols[i] = main_diag[i - row + n - 1] = anti_diag[i + row] = true;
        count += DFS(n, cols, main_diag, anti_diag, row + 1);
        cols[i] = main_diag[i - row + n - 1] = anti_diag[i + row] = false;
      }
    }

    return count;
  }
}