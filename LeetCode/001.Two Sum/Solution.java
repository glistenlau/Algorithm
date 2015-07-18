public class Solution {
  public int[] twoSum(int[] nums, int target) {
    int[] result = new int[2];
    if (nums == null || nums.length == 0) {
      return result;
    }

    HashMap<Integer, Integer> lookup = new HashMap<Integer, Integer>();

    for (int i = 0; i < nums.length; i++) {
      int temp = target - nums[i];
      if (lookup.containsKey(temp)) {
        result[0] = lookup.get(temp) + 1;
        result[1] = i + 1;
        return result;
      } else {
        lookup.put(nums[i], i);
      }
    }
    return result;
  }
}