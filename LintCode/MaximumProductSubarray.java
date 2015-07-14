/**
 * Maximum Product Subarray
 * www.lintcode.com/en/problem/maximum-product-subarray/
 *
 * Find the contiguous subarray within an array(containing at least one
 * number) which has the largest product.
 *
 * Example
 * For example, given the array [2, 3, -2, 4], the contiguous subarray[2, 3]
 * has the largest product = 6.
 */

public class Solution {
  /**
   * @param nums: an array of integers
   * @return: an integer
   */
  public int maxProduct(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    int[] max = new int[nums.length];
    int[] min = new int[nums.length];
    int result = nums[0];
    max[0] = min[0] = nums[0];
    for (int i = 1; i < nums.length; i++) {
      max[i] = min[i] = nums[i];
      if (nums[i] > 0) {
        max[i] = Math.max(max[i], max[i - 1] * nums[i]);
        min[i] = Math.min(min[i], min[i - 1] * nums[i]);
      }
      if (nums[i] < 0) {
        max[i] = Math.max(max[i], min[i - 1] * nums[i]);
        min[i] = Math.min(min[i], max[i - 1] * nums[i]);
      }
      result = Math.max(result, max[i]);
    }
    return result;
  }
}
