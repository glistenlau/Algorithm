public class Solution {
  public int[] searchRange(int[] nums, int target) {
    int[] result = {-1, -1};
    if (nums == null || nums.length == 0) {
      return result;
    }

    result[0] = findFisrt(nums, target);
    result[1] = findLast(nums, target);

    return result;
  }

  private int findFisrt(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;
    while (left + 1 < right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] >= target) {
        right = mid;
      } else {
        left = mid;
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

  private int findLast(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;
    while (left + 1 < right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] <= target) {
        left = mid;
      } else {
        right = mid;
      }
    }

    if (nums[right] == target) {
      return right;
    }
    if (nums[left] == target) {
      return left;
    }
    return -1;
  }
}