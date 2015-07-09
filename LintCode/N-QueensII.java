/**
 * N-Queens II
 * http://www.lintcode.com/en/problem/n-queens-ii/
 * Follow up for N-Queens problem.
 * Now, instead ouputting board configurations, return the total number of
 * distinct solutions.
 *
 * Example
 * For n = 4, there are 2 distinct solutions.
 */

class Solution {
  /**
   * Calculate the total number of distinct N-Queen solutions.
   * @param n: The number of queens.
   * @return: The total number of distinct solutions.
   */
  public int totalNQueens(int n) {
    if (n == 0) {
      return 0;
    }
    return countNQueens(n, new int[n], 0);
  }

  public int countNQueens(int n, int[] prePos, int pos) {
    if (pos == n) {
      return 1;
    }
    int result = 0;
    for( int j = 0; j < n; j++) {
      if (!valid(prePos, pos, j)) {
        continue;
      } else {
        prePos[pos] = j;
        result += countNQueens(n, prePos, pos + 1);
      }
    }
    return result;
  }

  private boolean valid(int[] prePos, int end, int target) {
    for (int i = 0; i < end; i++) {
      if (target == prePos[i]) {
        return false;
      }
      if (Math.abs(end - i) == Math.abs(target - prePos[i])) {
        return false;
      }
    }
    return true;

  }
};