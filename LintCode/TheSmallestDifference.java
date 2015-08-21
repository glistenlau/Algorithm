/**
 * The Smallest Difference
 * www.lintcode.com/en/problem/the-smallest-difference/
 *
 * Given two array of integer(the first array is array A, the second array is array B), now we are going to find
 * a element in array A which is A[i], and another element in array B which is B[j], so that the difference between
 * A[i] and B[j] is as small as possible, return their smallest difference.
 *
 * Example
 * Given array A = [3, 6, 7, 4], B = [2, 8, 9, 3], return 0.
 */
public class Solution {
  /**
   * @param A, B: Two integer arrays.
   * @return: Their smallest difference.
   */
  public int smallestDifference(int[] A, int[] B) {
    // write your code here
    if(A == null || B == null || A.length == 0 || B.length == 0) {
      return -1;
    }

    Arrays.sort(A);
    Arrays.sort(B);
    int a = 0;
    int b = 0;
    int diff = Integer.MAX_VALUE;
    while (a < A.length && b < B.length) {
      diff = Math.min(diff, Math.abs(A[a] - B[b]));
      if (A[a] <= B[b]) {
        a++;
      } else {
        b++;
      }
    }

    return diff;
  }
}