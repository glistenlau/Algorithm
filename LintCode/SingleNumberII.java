/**
 * Single Number II
 * www.lintcode.com/en/problem/single-number-ii/
 *
 * Given 3 * n + 1 numbers, every numbers occurs triple times except one,
 * find it.
 *
 * Example
 * Given [1, 1, 2, 3, 3, 3, 2, 2, 4, 1] return 4
 */

public class Solution {
  /**
   * @param A : An integer array
   * @return : An integer
   */
  public int singleNumberII(int[] A) {
    if (A == null || A.length == 0) {
      return -1;
    }

    int result = 0;
    int[] bits = new int[32];
    for (int i = 0; i < 32; i++) {
      for (int j = 0; j < A.length; j++) {
        bits[i] += A[j] >> i & 1;
      }
      bits[i] %= 3;
      result |= bits[i] << i;
    }
    return result;
  }
}
