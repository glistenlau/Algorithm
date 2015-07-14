/**
 * Sort Colors
 * www.lintcode.com/en/problem/sort-colors/
 *
 * Given an array with n objects coolored red, white or blue, sort them so
 * that objects of the same color are adjacent, with the colors in the order
 * red, white and blue.
 *
 * Here, we will use the integers 0, 1 and 2 to represent the color red,
 * white and blue respectively.
 *
 * Example
 * Given [1, 0, 1, 2], return [0, 1, 1, 2].
 */

class Solution {
  /**
   * @param nums: A list of integer which is 0, 1 or 2
   * @return: nothing
   */
  public void sortColors(int[] nums) {
    if (nums == null || nums.length == 0) {
      return;
    }

    int start = quickSort(nums, 1, 0, nums.length);
    quickSort(nums, 2, start, nums.length);
  }

  private int quickSort(int[] nums, int target, int start, int end) {
    int left = start;
    int right = end - 1;
    while (left <= right) {
      while (left <= right && nums[left] < target) {
        left++;
      }
      while (left <= right && nums[right] >= target) {
        right--;
      }
      if (left <= right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
      }
    }
    return left;
  }
}
