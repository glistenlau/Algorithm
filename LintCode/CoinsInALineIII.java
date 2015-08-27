/**
 * Coins in a Line III
 * www.lintcode.com/en/problem/coins-in-a-line-iii/
 *
 * There are n coins in a line. Two players take turns to take a coin from one of the ends of the line until
 * there are no more coins left. The player with the larger amount of money wins.
 * Could you please decide the first player will win or lose?
 *
 * Example
 * Given array A = [3, 2, 2], return true.
 * Given array A = [1, 2, 4], return true.
 * Given array A = [1, 20, 4], return false.
 */
public class Solution {
  /**
   * @param values: an array of integers
   * @return: a boolean which equals to true if the first player will win
   */
  public boolean firstWillWin(int[] values) {
    // write your code here
    int[][] dp = new int[values.length][values.length];
    boolean[][] visited = new boolean[values.length][values.length];
    int sum = 0;
    for (int value: values) {
      sum += value;
    }

    return sum < 2 * search(values, 0, values.length - 1, dp, visited);
  }

  private int search(int[] values, int left, int right, int[][] dp, boolean[][] visited) {
    if (left > right) {
      return 0;
    }
    if (visited[left][right]) {
      return dp[left][right];
    }

    if (left == 0 && right == 1) {
      dp[left][right] = Math.max(values[left], values[right]);
    } else if (left == values.length - 2 && right == values.length - 1) {
      dp[left][right] = Math.max(values[left], values[right]);
    } else if (left == right) {
      dp[left][right] = values[left];

    } else {
      dp[left][right] = Math.max(
          Math.min(search(values, left + 2, right, dp, visited), search(values, left + 1, right - 1, dp, visited)) + values[left],
          Math.min(search(values, left + 1, right - 1, dp, visited), search(values, left, right - 2, dp, visited)) + values[right]
      );
    }

    visited[left][right] = true;
    return dp[left][right];
  }
}
