/**
 * N-Queens
 * http://www.lintcode.com/en/problem/n-queens/
 *
 * The n-queens puzzle is the problem of placing n queens on an nxn
 * chessboard such that no two queens attack each other.
 *
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 *
 * Each solution contains a distinct board configuration of the n-queens'
 * placement, where 'Q' and '.' both indicate a queen and an empty space
 * respectively.
 *
 * Example
 * There exist two distinct solutions to the 4-queens puzzle:
 * [
 *   [".Q..",
 *    "...Q",
 *    "Q...",
 *    "..Q."],
 *   ["..Q.",
 *    "Q...",
 *    "...Q",
 *    ".Q.."]
 * ]
 */

class Solution {
  /**
   * Get all distinct N-Queen solutions
   * @param n: The number of queens
   * @return: All distinct solutions
   * For example, A string '...Q' shows a queen on forth position
   */
  ArrayList<ArrayList<String>> solveNQueens(int n) {
    ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
    NQueuesHelper(n, 0, new ArrayList<String>(), new int[n], result);
    return result;
  }

  private void NQueuesHelper(int n, int pos, ArrayList<String> taken, int[] prePos, ArrayList<ArrayList<String>> result) {
    if (taken.size() == n) {
      result.add(new ArrayList<String>(taken));
    }

    for (int i = 0; i < n; i++) {
      boolean valid = true;
      for (int j = 0; j < pos; j++) {
        if (i == prePos[j] || Math.abs(i - prePos[j]) == Math.abs(pos - j)) {
          valid = false;
          break;
        }
      }
      if (valid) {
        prePos[pos] = i;
        taken.add(generateString(i, n));
        NQueuesHelper(n, pos + 1, taken, prePos, result);
        taken.remove(taken.size() - 1);
      }
    }
  }

  private String generateString(int pos, int length) {
    String result = "";
    for (int i = 0; i < pos; i++) {
      result += ".";
    }
    result += "Q";
    for (int i = pos + 1; i < length; i++) {
      result += ".";
    }
    return result;
  }
};
