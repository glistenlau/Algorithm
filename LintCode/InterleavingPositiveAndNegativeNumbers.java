/**
 * Interleaving Positive and Negtive Numbers
 * www.lintcode.com/en/problem/interleaving-positive-and-negtive-numbers/
 *
 * Given an array with positive and negtive integers. Re-range it to interleaving with positive and negative integers.
 *
 * Example
 * Given [-1, -2, -3, 4, 5, 6], after rerange, it will be [-1, 5, -2, 4, -3, 6] or any other reasonable answer.
 */
class Solution {
  /**
   * @param A: An integer array.
   * @return: void
   */
  public void rerange(int[] A) {
    // write your code here
    if (A == null || A.length < 2) {
      return;
    }
    int count = 0;
    for (int num: A) {
      count += num > 0? 1: -1;
    }

    int neg  = count > 0? 1: 0;
    int pos = count > 0? 0: 1;

    while (neg < A.length && pos < A.length) {
      while (neg < A.length && A[neg] < 0) {
        neg += 2;
      }
      while (pos < A.length && A[pos] > 0) {
        pos += 2;
      }

      if (neg < A.length && pos < A.length) {
        int temp = A[neg];
        A[neg] = A[pos];
        A[pos] = temp;
      }
    }
  }
}
