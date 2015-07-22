public class Solution {
  public void solveSudoku(char[][] board) {
    isNiceTry(board);
  }

  private boolean isNiceTry(char[][] board) {

    int row = -1;
    int col = -1;
    HashSet<Character> nums = null;
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        if (board[i][j] == '.') {
          row = i;
          col = j;
          nums = getPossibleNums(board, i, j);
          if (nums.isEmpty()) {
            return false;
          }
          break;
        }
      }
      if (row != -1 && col != -1) {
        break;
      }
    }

    if (row == -1 && col == -1) {
      return true;
    }

    for (char i = '1'; i <= '9'; i++) {
      if (nums.contains(i)) {
        board[row][col] = i;
        if (isNiceTry(board)) {
          return true;
        }
      }
    }

    board[row][col] = '.';
    return false;
  }

  private HashSet<Character> getPossibleNums(char[][] board, int row, int col) {
    HashSet<Character> result = new HashSet<Character>();
    int[] nums = new int[256];
    int sqrRow = 3 * (row / 3);
    int sqrCol = 3 * (col / 3);
    for (int i = 0 ; i < 9; i++) {
      nums[board[row][i]] += 1;
      nums[board[i][col]] += 1;
      nums[board[sqrRow + i / 3][sqrCol + i % 3]] += 1;
    }
    for (char i = '1'; i <= '9'; i++) {
      if (nums[i] == 0) {
        result.add(i);
      }
    }
    return result;
  }
}