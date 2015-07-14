/**
 * Minimum Subarray
 * www.lintcode.com/en/problem/minimum-subarray/
 *
 * Given an array of integers, find the subarray with smallest sum.
 *
 * Return the sum of the subarray.
 *
 * Example
 * For [1, -1, -2, 1], return -3
 */

public class Solution {
  /**
   * @param nums: a list of integers
   * @return: A integer indicate the sum of minimum subarray
   */
  public int minSubArray(ArrayList<Integer> nums) {
    // write your code
    if (nums == null || nums.size() == 0) {
      return -1;
    }
    int[] sum = new int[nums.size()];
    sum[0] = nums.get(0);
    for (int i = 1; i < nums.size(); i++) {
      sum[i] = sum[i - 1] + nums.get(i);
    }
    int min = Integer.MAX_VALUE;
    int max = 0;
    for (int i = 0; i < nums.size(); i++) {
      min = Math.min(sum[i] - max, min);
      max = Math.max(sum[i], max);
    }
    return min;
  }
}