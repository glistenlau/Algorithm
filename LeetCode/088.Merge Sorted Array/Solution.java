public class Solution {
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int one = m - 1;
    int two = n - 1;
    for (int i = m + n - 1; i >= 0; i--) {
      if (one >= 0 && two >= 0) {
        if (nums1[one] > nums2[two]) {
          nums1[i] = nums1[one--];
        } else {
          nums1[i] = nums2[two--];
        }
      } else if (one >= 0) {
        nums1[i] = nums1[one--];
      } else if (two >= 0) {
        nums1[i] = nums2[two--];
      }
    }
  }
}