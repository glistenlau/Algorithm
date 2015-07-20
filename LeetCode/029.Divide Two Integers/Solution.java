public class Solution {
  public int divide(int dividend, int divisor) {
    if (divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1)) {
      return Integer.MAX_VALUE;
    }
    if (divisor == Integer.MIN_VALUE) {
      return dividend == Integer.MIN_VALUE ? 1 : 0;
    }

    boolean pos = (divisor < 0) ^ (dividend < 0) ? false : true;


    long dvd = Math.abs((long)dividend);
    long dvs = Math.abs((long)divisor);

    int result = 0;

    while (dvd >= dvs) {
      long temp = dvs;
      long count = 1;
      while((temp << 1) < dvd) {
        temp = temp << 1;
        count = count << 1;
      }

      result += count;
      dvd -= temp;
    }

    return pos ? result : -result;
  }
}