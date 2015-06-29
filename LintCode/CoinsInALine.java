/**
 * Coins in a Line
 * http://www.lintcode.com/en/problem/coins-in-a-line/
 *
 * There are n coins in a line. Two players take turns to take one or two
 * coins from right side until there are no more coins left. The player who
 * take the last coin wins.
 *
 * Example
 * n = 1, return true.
 * n = 2, return true.
 * n = 3, return false.
 * n = 4, return true.
 * n = 5, return true.
 */
public class Solution {
  /**
   * @param n: an integer
   * @return: a boolean which equals to true if the first player will win
   */
  public boolean firstWillWin(int n) {
    // write your code here
    if (n == 0) {
      return false;
    }
    if ( n < 3) {
      return true;
    }
    boolean last = true;
    boolean lastlast = true;
    for (int i = 2; i < n; i++) {
      boolean cur = !(last && lastlast);
      lastlast = last;
      last = cur;
    }
    return last;
  }
}
