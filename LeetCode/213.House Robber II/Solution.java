public class Solution {
  public int rob(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    if (nums.length < 2) {
      return nums[0];
    }

    return Math.max(money(nums, 1, nums.length -1), money(nums, 0, nums.length - 2));
  }

  private int money(int[] nums, int start, int end) {
    if (start > end) {
      return 0;
    }
    if (end == start) {
      return nums[start];
    }

    int[] dp = new int[end - start + 2];
    dp[0] = 0;
    dp[1] = nums[start];
    dp[2] = nums[start + 1];
    int max = Math.max(dp[1], dp[2]);

    for (int i = 3; i <= end - start + 1; i++) {
      dp[i] = Math.max(dp[i - 2], dp[i - 3]) + nums[start + i - 1];
      max = Math.max(max, dp[i]);
    }

    return max;
  }
}