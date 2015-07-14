/**
 * Maximum Subarray Difference
 * www.lintcode.com/en/problem/maximum-subarray-difference/
 *
 * Given an array with integers.
 * Find two non-overlapping subarrays A and B, which |SUM(A) - SUM(B)| is the
 * largest.
 * Return the largest difference.
 *
 * Example
 * For [1, 2, -3, 1], return 6.
 */

public class Solution {
  /**
   * @param nums: A list of integers
   * @return: An integer indicate the value of maximum difference between two
   *          Subarrays
   */
  public int maxDiffSubArrays(ArrayList<Integer> nums) {
    int[] leftMax = new int[nums.size()];
    int[] leftMin = new int[nums.size()];
    int[] rightMax = new int[nums.size()];
    int[] rightMin = new int[nums.size()];

    int sum = 0;
    int minSum = 0;
    int maxSum = 0;
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < nums.size(); i++) {
      sum += nums.get(i);
      max = Math.max(max, sum - minSum);
      min = Math.min(min, sum - maxSum);
      maxSum = Math.max(sum, maxSum);
      minSum = Math.min(sum, minSum);
      leftMax[i] = max;
      leftMin[i] = min;
    }

    sum = 0;
    minSum = 0;
    maxSum = 0;
    min = Integer.MAX_VALUE;
    max = Integer.MIN_VALUE;
    for (int i = nums.size() - 1; i >= 0; i--) {
      sum += nums.get(i);
      max = Math.max(max, sum - minSum);
      min = Math.min(min, sum - maxSum);
      maxSum = Math.max(sum, maxSum);
      minSum = Math.min(sum, minSum);
      rightMax[i] = max;
      rightMin[i] = min;
    }

    max = -1;
    for (int i = 0; i < nums.size() - 1; i++) {
      max = Math.max(max, Math.abs(leftMax[i] - rightMin[i + 1]));
      max = Math.max(max, Math.abs(leftMin[i] - rightMax[i + 1]));
    }
    return max;
  }
}


