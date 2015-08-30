public class Solution {
  public int missingNumber(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    for (int i = 0; i < nums.length; i++) {
      while (nums[i] < nums.length && nums[i] != i) {
        int temp = nums[nums[i]];
        nums[nums[i]] = nums[i];
        nums[i] = temp;
      }
    }

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != i) {
        return i;
      }
    }

    return nums.length;
  }
}