/**
 * First Missing Positive
 * www.lintcode.com/en/problem/first-missing-positive/
 *
 * Given an unsorted integer array, find the first missing positive ingteger.
 *
 * Example
 * Given [1, 2, 0] return 3, and [3, 4, -1, 1] return 2.
 */

public class Solution {
  /**
   * @param A: an array of integers
   * @return: an integer
   */
  // write your code here
  public int firstMissingPositive(int[] A) {
    if (A == null || A.length == 0) {
      return 1;
    }
    int i = 0;
    while (i < A.length) {
      if (A[i] > 0 && A[i] <= A.length) {
        if (A[i] != i + 1 && A[A[i] - 1] != A[i]) {
          int temp = A[A[i] - 1];
          A[A[i] - 1] = A[i];
          A[i] = temp;
        } else {
          i++;
        }
      } else {
        i++;
      }
    }
    for (i = 0; i < A.length; i++) {
      if (A[i] != i + 1) {
        return i + 1;
      }
    }
    return A.length + 1;
  }
}
