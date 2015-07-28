public class Solution {
  public int mySqrt(int x) {
    int left = 0;
    int right = x;

    while (left + 1 < right) {
      int mid = left + (right - left) / 2;
      if ((double)mid * mid == x) {
        return mid;
      } else if ((double)mid * mid < x) {
        left = mid;
      } else {
        right = mid;
      }
    }

    if ((double)right * right <= x) {
      return right;
    } else {
      return left;
    }
  }
}