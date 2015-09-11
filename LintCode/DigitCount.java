/**
 * Digit Counts
 * www.lintcode.com/en/problem/digit-counts/
 *
 * Count the number of k's between 0 and n. k can be 0-9.
 */
class Solution {
  /*
   * param k : As description.
   * param n : As description.
   * return: An integer denote the count of digit k in 1..n
   */
  public int digitCounts(int k, int n) {
    // write your code here
    int num = String.valueOf(n).length();
    int count = 0;
    for (int i = 0; i < num; i++) {
      count += countInRange(k, n, i);
    }

    return count;
  }

  private int countInRange(int k, int n, int i) {
    int powerOf10 = (int)Math.pow(10, i);
    int quotient = (n / powerOf10) % 10;
    int remain = n % powerOf10;

    int roundDown = n - n % (powerOf10 * 10);
    int roundUp = roundDown + powerOf10 * 10;

    if (qoute < k) {
      return roundDown / 10;
    } else if (qoute == k) {
      return roundDown / 10 + remain + 1;
    } else {
      return roundUp / 10;
    }
  }
};

