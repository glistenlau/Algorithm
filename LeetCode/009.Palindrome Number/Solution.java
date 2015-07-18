public class Solution {
  public boolean isPalindrome(int x) {
    int d = 1;

    while (x / d >= 10) {
      d *= 10;
    }

    while (d > 1) {
      int uni = x % 10;
      int big = x / d;
      if (uni != big) {
        return false;
      }
      x -= big * d;
      x /= 10;
      d /= 100;
    }

    return x >= 0 && x < 10 ? true : false;
  }
}