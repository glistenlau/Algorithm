/**
 * Subarray Sum
 * www.lintcode.com/en/problem/subarray-sum/
 *
 * Given an integer array, find a subarray where the sum of numbers is zero,
 * Your code should return the index of the first number and the index of the
 * last number.
 *
 * Example
 * Given [-3, 1, 2, -3, 4], return [0, 2] or [1, 3].
 */

public class Solution {
  /**
   * @param nums: A list of integers
   * @return: A list of integers includes the index of the first number
   *          and the index of the last number
   */
  public ArrayList<Integer> subarraySum(int[] nums) {
    // write your code here
    ArrayList<Integer> result = new ArrayList<Integer>();
    if (nums == null || nums.length == 0) {
      return result;
    }
    HashMap<Integer, Integer> lookup = new HashMap<Integer, Integer>();
    int pre = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 0) {
        result.add(i);
        result.add(i);
        break;
      }
      if (pre + nums[i] == 0) {
        result.add(0);
        result.add(i);
        break;
      }
      if (lookup.containsKey(pre + nums[i])) {
        result.add(lookup.get(pre + nums[i]) + 1);
        result.add(i);
        break;
      } else {
        pre += nums[i];
        lookup.put(pre, i);
      }
    }
    return result;
  }
}
