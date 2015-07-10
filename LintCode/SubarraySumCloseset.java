/**
 * Given an integer array, find a subarray with sum closest  to zero, Return
 * the indexs of the first number and the last number.
 *
 * Example
 * Given [-3, 1, 1, -3, 5], return [0, 2], [1, 3], [1, 1], [2, 2] or [0, 4]
 */

public class Solution {
  /**
   * @param nums: A list of integers
   * @return: A list of integers includes the index of the first number
   *          and the index of the last number
   */
  public ArrayList<Integer> subarraySumClosest(int[] nums) {
    ArrayList<Integer> result = new ArrayList<Integer>();
    if (nums == null || nums.length == 0) {
      return result;
    }
    result.add(0);
    result.add(0);
    int[] lookup = new int[nums.length];
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    lookup[0] = nums[0];
    map.put(lookup[0], 0);
    for (int i = 1; i < nums.length; i++) {
      lookup[i] = lookup[i - 1] + nums[i];
      if (!map.containsKey(lookup[i])) {
        map.put(lookup[i], i);
      } else {
        result.clear();
        result.add(map.get(lookup[i]) + 1);
        result.add(i);
        return result;
      }
    }
    Arrays.sort(lookup);
    int minDiff = Integer.MAX_VALUE;
    for (int i = 1; i < nums.length; i++) {
      if (Math.abs(lookup[i] - lookup[i - 1]) < minDiff) {
        minDiff = Math.abs(lookup[i] - lookup[i - 1]);
        updateResult(map.get(lookup[i]), map.get(lookup[i - 1]), result);
      }
    }
    return result;
  }

  private void updateResult(int a, int b, ArrayList<Integer> result) {
    if (a > b) {
      int temp = a;
      a = b;
      b = temp;
    }
    result.clear();
    result.add(a + 1);
    result.add(b);
  }
}