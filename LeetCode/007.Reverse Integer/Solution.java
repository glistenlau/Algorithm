public class Solution {
  public int reverse(int x) {
    int result = 0;
    boolean pos = true;

    while (x != 0) {
      if ((result > Integer.MAX_VALUE / 10) || (result == Integer.MAX_VALUE / 10 && x % 10 > 7)) {
        result = 0;
        break;
      }
      if ((result < Integer.MIN_VALUE / 10) || (result == Integer.MIN_VALUE / 10 && x % 10 < -8)) {
        result = 0;
        break;
      }
      result *= 10;
      result += x % 10;
      x /= 10;
    }

    return result;
  }
}