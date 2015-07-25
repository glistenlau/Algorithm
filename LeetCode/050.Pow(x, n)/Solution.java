public class Solution {
  public double myPow(double x, int n) {
    if (n == 0) {
      return 1;
    }

    double odd = n < 0? 1 / x : x;
    double temp = myPow(x, n / 2);

    return n % 2 == 0? temp * temp : temp * temp * odd;
  }
}