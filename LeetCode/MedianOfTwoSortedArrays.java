import java.util.Arrays;

/**
 * Created by YiLIU on 6/11/15.
 */
public class MedianOfTwoSortedArrays {
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int m = nums1.length;
    int n = nums2.length;
    if ((m + n) % 2 == 0) {
      return (double)(kth(nums1, nums2, (m + n) / 2) + kth(nums1, nums2, (m +
          n) / 2 - 1)) / 2.0;
    } else {
      return kth(nums1, nums2, (m + n) / 2);
    }

 }

  private int kth(int[] nums1, int[] nums2, int k) {
    int m = nums1.length;
    int n = nums2.length;
    if (m == 0) return nums2[k];
    if (n == 0) return nums1[k];
    int in1 = m / 2;
    int in2 = n / 2;
    int mid1 = nums1[in1];
    int mid2 = nums2[in2];
    if (in1 + in2 < k) {
      if (mid1 > mid2) {
        return kth(nums1, Arrays.copyOfRange(nums2, in2 + 1, n), k - in2 - 1);
      } else {
        return kth(Arrays.copyOfRange(nums1, in1 + 1, m), nums2, k - in1 - 1);
      }
    } else {
      if (mid1 > mid2) {
        return kth(Arrays.copyOfRange(nums1, 0, in1), nums2, k);
      } else {
        return kth(nums1, Arrays.copyOfRange(nums2, 0, in2), k);
      }
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

  public static void main(String[] args) {
    int[] nums1 = {1, 2};
    int[] nums2 = {1, 1};
    System.out.println(new MedianOfTwoSortedArrays().findMedianSortedArrays
        (nums1, nums2));
  }
}
