/**
 * Coins in a Line II
 * www.lintcode.com/en/problem/coins-in-a-line-ii/
 *
 * There are n coins with different value in a line. Two players take turns to take one or two coins from left side
 * until there are no more coins left. The player who take the coins with the most value wins.
 *
 * Example
 * Given values array A = [1, 2, 2], return true;
 * Given A = [1, 2, 4], return false;
 */
public class Solution {
  /**
   * @param values: an array of integers
   * @return: a boolean which equals to true if the first player will win
   */
  public boolean firstWillWin(int[] values) {
    if (values == null || values.length == 0) {
      return true;
    }

    int[] f = new int[values.length + 1];
    boolean[] visited = new boolean[values.length + 1];

    int sum = 0;
    for (int val: values) {
      sum += val;
    }

    return sum < 2 * search(values.length, values, f, visited);
  }

  private int search(int n, int[] values, int[] f, boolean[] visited) {
    if (visited[n]) {
      return f[n];
    }
    visited[n] = true;

    if (n == 0) {
      f[n] = 0;
    } else if (n == 1) {
      f[n] = values[values.length - 1];
    } else if (n == 2) {
      f[n] = values[values.length - 1] + values[values.length - 2];
    } else if (n == 3) {
      f[n] = values[values.length - 2] + values[values.length - 3];
    } else {
      f[n] = Math.max(
          Math.min(search(n - 2, values, f, visited), search(n - 3, values, f, visited)) + values[values.length - n],
          Math.min(search(n - 3, values, f, visited), search(n - 4, values, f, visited)) + values[values.length - n] + values[values.length - n + 1]
      );
    }

    return f[n];
  }
}

