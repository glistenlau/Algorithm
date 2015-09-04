/**
 * Find the Missing Number
 * www.lintcode.com/en/problem/find-the-missing-number/
 *
 * Given an array contains N numbers of 0...N, find which number doesn't exist in the array.
 *
 * Example
 * Given N = 3, and the array[0, 1, 3], return 2.
 */
public class Solution {
  /**
   * @param nums: an array of integers
   * @return: an integer
   */
  public int findMissing(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    for (int i = 0; i < nums.length; i++) {
      while (nums[i] < nums.length && nums[i] != i) {
        swap(nums, i, nums[i]);
      }
    }

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != i) {
        return i;
      }
    }

    return nums.length;
  }

  private void swap(int[] nums, int a, int b) {
    int temp = nums[a];
    nums[a] = nums[b];
    nums[b] = temp;
  }
}
