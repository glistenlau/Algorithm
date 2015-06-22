/**
 * Binary Search
 * http://www.lintcode.com/en/problem/binary-search/
 *
 * For a given sorted array (ascending order) and a target number, find the
 * first index of this number in O(log n) time complexity.
 *
 * If the target number does not exist in the array, return -1.
 *
 * Example
 * If the array is [1, 2, 3, 3, 4, 5, 10], for given target 3, return 2.
 */
class Solution {
  /**
   * @param nums: The integer array.
   * @param target: Target to find.
   * @return: The first position of target. Position starts from 0.
   */
  public int binarySearch(int[] nums, int target) {
    //write your code here
    int left = 0;
    int right = nums.length - 1;
    while (left + 1 < right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] == target) {
        right = mid;
      } else if (nums[mid] > target) {
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
}