/**
 * Longest Increasing Subsequence
 * http://www.lintcode.com/en/problem/longest-increasing-subsequence/
 *
 * Given a sequence of integers, find the longest increasing subsequence (LIS).
 *
 * You code should return the length of the LIS.
 *
 * Example
 * For [5, 4, 1, 2, 3], the LIS  is [1, 2, 3], return 3
 * For [4, 2, 4, 5, 3, 7], the LIS is [4, 4, 5, 7], return 4
 */
public class Solution {
  /**
   * @param nums: The integer array
   * @return: The length of LIS (longest increasing subsequence)
   */
  public int longestIncreasingSubsequence(int[] nums) {
    // write your code here
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int[] count = new int[nums.length ];
    Arrays.fill(count, 1);
    int max = 0;
    for (int i = 0; i < nums.length; i++) {
      for (int j = 0; j < i; j++) {
        if (nums[i] >= nums[j]) {
          count[i] = Math.max(count[i], count[j] + 1);
        }
      }
      if (count[i] > max) {
        max = count[i];
      }
    }
    return max;
  }
}
