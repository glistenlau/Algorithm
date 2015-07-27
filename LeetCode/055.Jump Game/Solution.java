public class Solution {
  public boolean canJump(int[] nums) {
    if (nums == null || nums.length < 2) {
      return true;
    }
    int curEnd = 0;
    int maxEnd = 0;

    for (int i = 0; i < nums.length - 1; i++) {
      if (curEnd < i) {
        return false;
      }
      maxEnd = Math.max(maxEnd, nums[i] + i);
      if (maxEnd >= nums.length - 1) {
        return true;
      }
      if (curEnd == i) {
        curEnd = maxEnd;
      }
    }
    return false;
  }
}