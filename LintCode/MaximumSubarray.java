/**
 * Maximum Subarray
 * www.lintcode.com/en/problem/maximum-subarray/
 *
 * Given an array of integers, find a contiguous subarray which has the
 * largest sum.
 *
 * Example
 * Given the array [-2, 2, -3, 4, -1, 2, 1, -5, 3], the contiguous
 * subarray[4, -1, 2, 1] has the largest sum = 6.
 */

public class Solution {
  /**
   * @param nums: A list of integers
   * @return: A integer indicate the sum of max subarray
   */
  public int maxSubArray(ArrayList<Integer> nums) {
    if (nums == null || nums.size() == 0) {
      return -1;
    }

    int[] sum = new int[nums.size()];
    sum[0] = nums.get(0);
    for (int i = 1; i < nums.size(); i++) {
      sum[i] = sum[i - 1] + nums.get(i);
    }
    int max = Integer.MIN_VALUE;
    int min = 0;
    for (int n : sum) {
      max = Math.max(max, n - min);
      min = Math.min(min, n);
    }
    return max;
  }
}
