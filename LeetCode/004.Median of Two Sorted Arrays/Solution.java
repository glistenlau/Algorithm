public class Solution {
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int len = nums1.length + nums2.length;
    if (len % 2 == 0) {
      return (double) (findKth(nums1, 0, nums2, 0, len / 2) +
          findKth(nums1, 0, nums2, 0, len / 2 + 1)) / 2.0;
    } else {
      return (double) findKth(nums1, 0, nums2, 0, len / 2 + 1);
    }
  }

  private int findKth(int[] nums1, int n1S, int[] nums2, int n2S, int k) {
    if (n1S >= nums1.length) {
      return nums2[n2S + k - 1];
    }
    if (n2S >= nums2.length) {
      return nums1[n1S + k - 1];
    }

    if (k == 1) {
      return Math.min(nums1[n1S], nums2[n2S]);
    }

    int n1V = n1S + k / 2 - 1 < nums1.length ? nums1[n1S + k / 2 - 1] : Integer.MAX_VALUE;
    int n2V = n2S + k / 2 - 1 < nums2.length ? nums2[n2S + k / 2 - 1] : Integer.MAX_VALUE;

    if (n1V < n2V) {
      return findKth(nums1, n1S + k / 2, nums2, n2S, k - k / 2);
    } else {
      return findKth(nums1, n1S, nums2, n2S + k / 2, k - k / 2);
    }
  }
}