/**
 * Fast Power
 * www.lintcode.com/en/problem/fast-power/
 *
 * Calculate the a ^ n % b, where a, b and n are all 32-bit integers.
 *
 * Example
 * For 2 ^ 31 % 3 = 2.
 * FOr 100 ^ 1000 % 1000 = 0.
 */

class Solution {
  /*
   * @param a, b, n: 32bit integers
   * @return: An integer
   */
  public int fastPower(int a, int b, int n) {
    if (n == 0) {
      return 1 % b;
    }
    long product = fastPower(a, b, n / 2);
    product = (product * product) % b;
    if (n % 2 == 1) {
      product = (product * a) % b;
    }
    return (int)product;
  }
};
