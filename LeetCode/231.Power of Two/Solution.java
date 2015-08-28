public class Solution {
  public boolean isPowerOfTwo(int n) {
    if (n < 0) {
      return false;
    }
    boolean one = false;

    for (int i = 0; i < 31; i++) {
      if (((n >> i) & 1) == 1) {
        if (one) {
          return false;
        } else {
          one = true;
        }
      }
    }

    return one;
  }
}