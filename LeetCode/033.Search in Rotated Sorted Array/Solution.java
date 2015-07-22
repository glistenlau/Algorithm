public class Solution {
  public int search(int[] nums, int target) {
    if (nums == null || nums.length == 0) {
      return -1;
    }

    int first = nums[0];
    int left = 0;
    int right = nums.length - 1;

    while (left + 1 < right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] == target) {
        return mid;
      }

      if (nums[mid] < first) {
        if (nums[mid] > target) {
          right = mid;
        } else {
          if (target < first) {
            left = mid;
          } else {
            right = mid;
          }
        }
      } else {
        if (nums[mid] < target) {
          left = mid;
        } else {
          if (target < first) {
            left = mid;
          } else {
            right = mid;
          }
        }
      }
    }

    if (nums[left] == target) {
      return left;
    }
    if (nums[right] == target) {
      return right;
    }
    return -1;
  }
}