public class Solution {
  public int minSubArrayLen(int s, int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    int ans = Integer.MAX_VALUE;
    int sum = 0;
    int left = 0;

    for (int right = 0; right < nums.length; right++) {
      sum += nums[right];
      while (sum >= s) {
        ans = Math.min(ans, right - left + 1);
        sum -= nums[left];
        left++;
      }
    }

    return ans == Integer.MAX_VALUE? 0: ans;
  }
}