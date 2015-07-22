public class Solution {
  public int firstMissingPositive(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 1;
    }

    int i = 0;
    while (i < nums.length) {
      while (nums[i] != i + 1 && i >= 0 && i < nums.length && nums[i] > 0 && nums[i] < nums.length) {
        if (nums[i] == nums[nums[i] - 1]) {
          break;
        }
        int temp = nums[nums[i] - 1];
        nums[nums[i] - 1] = nums[i];
        nums[i] = temp;
      }
      i++;
    }

    for (i = 0; i < nums.length; i++) {
      if (nums[i] != i + 1) {
        return i + 1;
      }
    }
    return nums.length + 1;
  }
}