public class Solution {
  public int singleNumber(int[] nums) {
    if (nums == null || nums.length == 0) {
      return -1;
    }

    int num = nums[0];
    for (int i = 1; i < nums.length; i++) {
      num ^= nums[i];
    }
    return num;
  }
}