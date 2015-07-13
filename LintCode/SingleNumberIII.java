/**
 * Single Number III
 * www.lintcode.com/en/problem/single-number-iii/#
 *
 * Given 2 * n + 2 numbers, every numbers occurs twice except two, find them.
 *
 * Example
 * Given [1, 2, 2, 3, 4, 4, 5, 3], return 1 and 5.
 */

public class Solution {
  /**
   * @param A : An integer array
   * @return : Two integers
   */
  public List<Integer> singleNumberIII(int[] A) {
    List<Integer> result = new ArrayList<Integer>();
    if (A == null || A.length == 0) {
      return result;
    }

    int m = A[0];
    for (int i = 1; i < A.length; i++) {
      m ^= A[i];
    }

    m = m - ((m - 1) & m);
    int shift = 0;
    while (m != 1) {
      m = m >>> 1;
      shift++;
    }

    m = 0;
    int n = 0;
    for (int i = 0; i < A.length; i++) {
      if (((A[i] >>> shift) & 1) == 1) {
        m ^= A[i];
      } else {
        n ^= A[i];
      }
    }
    result.add(m);
    result.add(n);
    return result;
  }

}
