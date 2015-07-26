public class Solution {
  public int maxSubArray(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    int sum = 0;
    int minSum = 0;
    int max = Integer.MIN_VALUE;

    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      max = Math.max(max, sum - minSum);
      minSum = Math.min(minSum, sum);
    }

    return max;
  }
}