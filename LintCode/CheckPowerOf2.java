/**
 * Using O(1) time to check whether an integer n is a power of 2.
 * www.lintcode.com/en/problem/o1-check-power-of-2/
 *
 * Using O(1) time to check whether an integer n is a power of 2.
 *
 * Example
 * for n = 4, return true;
 * for n = 5, return false;
 */

class Solution {
  /*
   * @param n: An integer
   * @return: True or false
   */
  public boolean checkPowerOf2(int n) {
    // write your code here
    return (n > 0) && (n & (n - 1)) == 0;
  }
};