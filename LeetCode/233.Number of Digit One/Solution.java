public class Solution {
  public int countDigitOne(int n) {
    if (n == 0) {
      return 0;
    }

    long ans = 0;
    long pre = 0;
    long base = 1;

    while (n >= base) {
      long i = (n / base) % 10;
      long r = n % base;
      if (i > 1) {
        ans += i * pre + base;
      } else if (i == 1) {
        ans += i * pre + r + 1;
      }

      pre = pre * 10 + base;
      base *= 10;
    }

    return (int)ans;
  }
}