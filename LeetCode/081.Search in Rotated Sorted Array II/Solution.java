public class Solution {
  public boolean search(int[] nums, int target) {
    if (nums == null || nums.length == 0) {
      return false;
    }
    int e = nums.length - 1;
    while (e >= 0 && nums[0]  == nums[e]) {
      e--;
    }

    if (e < 0) {
      return nums[0] == target;
    }

    int left = 0;
    int right = e;

    while (left + 1 < right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] == target) {
        return true;
      } else if (nums[mid] < target) {
        if (nums[mid] < nums[0]) {
          if (target < nums[0]) {
            left = mid;
          } else {
            right = mid;
          }
        } else {
          left = mid;
        }
      } else {
        if (nums[mid] < nums[0]) {
          right = mid;
        } else {
          if (target < nums[0]) {
            left = mid;
          } else {
            right = mid;
          }
        }
      }
    }

    if (nums[left] == target || nums[right] == target) {
      return true;
    }

    return false;
  }
}