/**
 * Sqrt(x)
 * www.lintcode.com/en/problem/sqrtx/
 *
 * Compute and return the quare root of x.
 *
 * Example
 * sqrt(3) = 1
 * sqrt(4) = 2
 * sqrt(5) = 2
 * sqrt(10) = 3
 */

class Solution {
  /**
   * @param x: An integer
   * @return: The sqrt of x
   */
  public int sqrt(int x) {
    long left = 0;
    long right = x;
    while(left <= right) {
      long mid = left + (right - left) / 2;
      if (x < mid * mid) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return (int)right;
  }
}