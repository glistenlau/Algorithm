public class Solution {
  public int findPeakElement(int[] nums) {
    if (nums == null || nums.length == 0) {
      return -1;
    }

    int left = 0;
    int right = nums.length - 1;
    while (left + 1 < right) {
      int mid = left + (right - left) / 2;
      if (mid > 0 && nums[mid] < nums[mid - 1]) {
        right = mid;
      } else if (mid < nums.length - 1 && nums[mid] < nums[mid + 1]) {
        left = mid;
      } else {
        return mid;
      }
    }

    return nums[left] > nums[right]? left: right;
  }
}