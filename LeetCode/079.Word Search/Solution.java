public class Solution {
  public boolean exist(char[][] board, String word) {
    if (board == null) {
      return false;
    }
    if (word == null || word.length() == 0) {
      return true;
    }
    int m = board.length;
    int n = board[0].length;
    if (m * n < word.length()) {
      return false;
    }

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (board[i][j] == word.charAt(0)){
          boolean[][] used = new boolean[m][n];
          used[i][j] = true;
          if (findRemaining(board, 1, i, j, word, used)) {
            return true;
          }
        }
      }
    }
    return false;
  }

  private boolean findRemaining(char[][] board, int pos, int row, int col, String word, boolean[][] used) {
    if (pos == word.length()) {
      return true;
    }

    for(int r = row - 1; r <= row + 1; r++) {
      if (r == row || r < 0 || r >= board.length || used[r][col] || board[r][col] != word.charAt(pos)) {
        continue;
      }
      used[r][col] = true;
      if (findRemaining(board, pos + 1, r, col, word, used)) {
        return true;
      }
      used[r][col] = false;
    }

    for(int c = col - 1; c <= col + 1; c++) {
      if (c == col || c < 0 || c >= board[0].length || used[row][c] || board[row][c] != word.charAt(pos)) {
        continue;
      }
      used[row][c] = true;
      if (findRemaining(board, pos + 1, row, c, word, used)) {
        return true;
      }
      used[row][c] = false;
    }

    return false;
  }
}

