public class Solution {
  public void gameOfLife(int[][] board) {
    if (board == null || board.length == 0) {
      return;
    }
    if (board[0] == null || board[0].length == 0) {
      return;
    }

    for (int r = 0; r < board.length; r++) {
      for (int c = 0; c < board[0].length; c++) {
        if (board[r][c] == 0) {
          board[r][c] = -10;
        }
        board[r][c] += getLiveNum(board, r, c);
      }
    }
    
    for (int r = 0; r < board.length; r++) {
      for (int c = 0; c < board[0].length; c++) {
        if (board[r][c] > 0) {
          if (board[r][c] == 3 || board[r][c] == 4) {
            board[r][c] = 1;
          } else {
            board[r][c] = 0;
          }
        } else {
          if (board[r][c] == -7) {
            board[r][c] = 1;
          } else {
            board[r][c] = 0;
          }
        }
      }
    }
  }

  private int getLiveNum(int[][] board, int r, int c) {
    int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    int ans = 0;
    for (int i = 0; i < 8; i++) {
      int row = r + dx[i];
      int col = c + dy[i];
      if (row >= 0 && row < board.length && col >= 0 && col < board[0].length) {
        if (board[row][col] > 0) {
          ans++;
        }
      }
    }

    return ans;
  }
}
