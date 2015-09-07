/**
 * Valid Sudoku
 * www.lintcode.com/en/problem/valid-sudoku/
 *
 * Determine whether a Sudoku is valid.
 *
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 */
class Solution {
  /**
   * @param board: the board
   @return: wether the Sudoku is valid
   */
  public boolean isValidSudoku(char[][] board) {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (board[i][j] != '.' && !check(board, i, j)) {
          return false;
        }
      }
    }

    return true;
  }

  private boolean check(char[][] board, int row, int col) {
    char tar = board[row][col];
    for (int i = 0; i < board.length; i++) {
      if (i != row && board[i][col] == tar) {
        return false;
      }
    }

    for (int j = 0; j < board[0].length; j++) {
      if (j != col && board[row][j] == tar) {
        return false;
      }
    }

    int r = 3 * (row / 3);
    int c = 3 * (col / 3);

    for (int i = r; i < r + 3; i++) {
      for (int j = c; j < c + 3; j++) {
        if ((i != row || j != col) && board[i][j] == tar) {
          return false;
        }
      }
    }

    return true;
  }
};
