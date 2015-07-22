public class Solution {
  public int searchInsert(int[] nums, int target) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    int left = 0;
    int right = nums.length - 1;

    while (left + 1 < right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] == target) {
        return mid;
      }

      if (nums[mid] < target) {
        left = mid;
      } else {
        right = mid;
      }
    }

    if (target <= nums[left]) {
      return 0;
    } else if (target > nums[right]) {
      return right + 1;
    } else {
      return right;
    }
  }
}