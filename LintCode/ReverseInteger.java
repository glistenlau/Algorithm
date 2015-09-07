/**
 * Reverse Integer
 * Reverse digits of an integer. Return 0 when the reversed integer overflows(signed 32-bit integer);
 */
public class Solution {
  /**
   * @param n the integer to be reversed
   * @return the reversed integer
   */
  public int reverseInteger(int n) {
    // Write your code here
    int max = Integer.MAX_VALUE / 10;
    int min = Integer.MIN_VALUE / 10;
    int ans = 0;

    while (n != 0) {
      int num = n % 10;
      if (ans > max || ans < min) {
        return 0;
      }
      if (ans == max && num > 7) {
        return 0;
      }
      if (ans == min && num < -8) {
        return 0;
      }
      ans = ans * 10 + num;
      n /= 10;
    }

    return ans;
  }
}
