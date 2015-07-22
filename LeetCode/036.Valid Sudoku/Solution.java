public class Solution {
  public boolean isValidSudoku(char[][] board) {
    for (int i = 0; i < board.length; i++) {
      HashSet<Character> checkRow = new HashSet<Character>();
      HashSet<Character> checkCol = new HashSet<Character>();
      HashSet<Character> checkSqr = new HashSet<Character>();
      for (int j = 0; j < board[i].length; j++) {
        int sqrRow = 3 * (i / 3);
        int sqrCol = 3 * (i % 3);

        char sqrCh = board[sqrRow + j / 3][sqrCol + j % 3];
        char rowCh = board[i][j];
        char colCh = board[j][i];

        if (sqrCh != '.') {
          if (checkSqr.contains(sqrCh)) {
            return false;
          }
          checkSqr.add(sqrCh);
        }
        if (rowCh != '.') {
          if (checkRow.contains(rowCh)) {
            return false;
          }
          checkRow.add(rowCh);
        }
        if (colCh != '.') {
          if (checkCol.contains(colCh)) {
            return false;
          }
          checkCol.add(colCh);
        }

      }
    }

    return true;
  }
}