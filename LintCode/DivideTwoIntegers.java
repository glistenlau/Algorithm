/**
 * Divide Two Integers
 * www.lintcode.com/en/problem/divide-two-integers/
 *
 * Divide two integers without using nultiplication, division and mod operator.
 * If it is overflow, return 2147483647.
 */
public class Solution {
  /**
   * @param dividend the dividend
   * @param divisor the divisor
   * @return the result
   */
  public int divide(int dividend, int divisor) {
    // Write your code here
    long divd = Math.abs((long) dividend);
    long divr = Math.abs((long) divisor);
    if (dividend == Integer.MIN_VALUE && divisor == -1) {
      return 2147483647;
    }
    if (Math.abs(divd) < Math.abs(divr)) {
      return 0;
    }

    if (divisor == 0) {
      return 2147483647;
    }

    boolean neg = false;
    if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
      neg = true;
    }

    long q = 1L;
    while ((divr << 1) <= divd) {
      q = q << 1;
      divr = divr << 1;
    }

    long r = divd - divr;

    if (neg) {
      q = -q;
    }
    if (dividend < 0) {
      r = -r;
    }

    return (int)q + divide((int) r, divisor);
  }
}
