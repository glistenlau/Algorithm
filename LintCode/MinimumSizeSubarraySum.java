/**
 * Minimum Size Subarray Sum
 * www.lintcode.com/en/problem/minimum-size-subarray-sum/
 *
 * Given an array of n positive integers and positive integer s, find the minimal length of a subarray of which
 * the sum ≥ s. If there isn't one, return -1.
 *
 * Example
 * Given the array [2, 3, 1, 2, 4, 3] and s = 7, the subarray [4, 3] has the minimal length under the problem constraint.
 */
public class Solution {
  /**
   * @param nums: an array of integers
   * @param s: an integer
   * @return: an integer representing the minimum size of subarray
   */
  public int minimumSize(int[] nums, int s) {
    // write your code here
    if (nums == null || nums.length == 0) {
      return -1;
    }

    int result = Integer.MAX_VALUE;
    int start = 0;
    int end = 0;
    int sum = nums[0];

    while (start < nums.length && end < nums.length) {
      if (sum >= s) {
        result = Math.min(result, end - start + 1);
        sum -= nums[start++];
      } else {
        sum += ++end < nums.length? nums[end]: 0;
      }
    }

    return result == Integer.MAX_VALUE? -1: result;
  }
}
