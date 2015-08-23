public class Solution {
  public int rob(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    int prePre = 0;
    int pre = nums[0];
    for (int i = 2; i <= nums.length; i++) {
      int cur = Math.max(pre, prePre + nums[i - 1]);
      prePre = pre;
      pre = cur;
    }

    return pre;
  }
}