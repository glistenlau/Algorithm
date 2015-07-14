/**
 * Flip Bits
 * www.lintcode.com/en/problem/flip-bits/
 *
 * Determine the number of bits required to flip if you want to convert
 * integer n = integer m.
 *
 * Example
 * Given n = 31 (11111), m = 14(01110), return 2.
 */

class Solution {
  /**
   *@param a, b: Two integer
   *return: An integer
   */
  public static int bitSwapRequired(int a, int b) {
    int op = a ^ b;
    int count = 0;
    for (int i = 0; i < 32; i++) {
      if ((op >>> i & 1) == 1) {
        count++;
      }
    }
    return count;
  }
};