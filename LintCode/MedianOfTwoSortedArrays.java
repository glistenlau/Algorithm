/**
 * Median of two Sorted Arrays
 * http://www.lintcode.com/en/problem/median-of-two-sorted-arrays/
 *
 * There are two sorted arrays A and B of size m and n respectively. Find the
 * median of the two sorted arrays.
 *
 * Example
 * Given A=[1,2,3,4,5,6] and B=[2,3,4,5], the median is 3.5.
 * Given A=[1,2,3] and B=[4,5], the median is 3.
 */
class Solution {
  /**
   * @param A: An integer array.
   * @param B: An integer array.
   * @return: a double whose format is *.5 or *.0
   */
  public double findMedianSortedArrays(int[] A, int[] B) {
    // write your code here
    int len = A.length + B.length;
    if (len % 2 == 0) {
      return (kth(A, 0, B, 0, len / 2) + kth(A, 0, B, 0, len / 2 + 1)) / 2.0;
    } else {
      return kth(A, 0, B, 0, len / 2 + 1) / 1.0;
    }
  }

  private int kth(int[] nums1, int startA, int[] nums2, int startB, int k) {
    if (startA >= nums1.length) {
      return nums2[startB + k - 1];
    }
    if (startB >= nums2.length) {
      return nums1[startA + k - 1];
    }

    if (k == 1) {
      return Math.min(nums1[startA], nums2[startB]);
    }

    int A_key = startA + k / 2 - 1 < nums1.length ? nums1[startA + k / 2 - 1] :
        Integer.MAX_VALUE;
    int B_key = startB + k / 2 - 1 < nums2.length ? nums2[startB + k / 2 - 1] :
        Integer.MAX_VALUE;

    if (A_key < B_key) {
      return kth(nums1, startA + k / 2, nums2, startB, k - k / 2);
    } else {
      return kth(nums1, startA, nums2, startB + k / 2, k - k / 2);
    }
  }
}