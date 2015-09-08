/**
 * Word Search
 * www.lintcode.com/en/problem/word-search/
 *
 * Given a 2D board and a word, find if the word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or
 * vertically neighboring. The same letter cell may not be used more than onece.
 */
public class Solution {
  /**
   * @param board: A list of lists of character
   * @param word: A string
   * @return: A boolean
   */
  public boolean exist(char[][] board, String word) {
    if (word == null || word.length() == 0) {
      return true;
    }
    if (board == null || board.length == 0 || board[0].length == 0) {
      return false;
    }
    boolean[][] visited = new boolean[board.length][board[0].length];
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (board[i][j] == word.charAt(0)) {
          if (search(board, i, j, 1, word, visited)) {
            return true;
          }
        }
      }
    }

    return false;
  }

  private boolean search(char[][] board, int row, int col, int index, String word, boolean[][] visited) {
    if (visited[row][col]) {
      return false;
    }
    if (index == word.length()) {
      return true;
    }

    int[] dx = {0, 0, -1, 1};
    int[] dy = {1, -1, 0, 0};

    visited[row][col] = true;

    for (int i = 0; i < 4; i++) {
      int r = row + dx[i];
      int c = col + dy[i];
      if (r >= 0 && r < board.length && c >= 0 && c < board[0].length) {
        if (board[r][c] == word.charAt(index) && search(board, r, c, index + 1, word, visited)) {
          return true;
        }
      }
    }

    visited[row][col] = false;
    return false;
  }
}
