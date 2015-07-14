/**
 * Trailing Zeros
 * www.lintcode.com/en/problem/trailing-zeros/
 *
 * Write an algorithm which computes the number of trailing zeros in n
 * factorial.
 *
 * Example
 * 11! = 39916800, so the out should be 2.
 */

class Solution {
  /*
   * param n: As desciption
   * return: An integer, denote the number of trailing zeros in n!
   */
  public long trailingZeros(long n) {
    long count = 0L;
    while (n / 5 > 0) {
      count += n / 5;
      n /= 5;
    }
    return count;
  }
};

