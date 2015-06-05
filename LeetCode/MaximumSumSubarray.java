/**
 * Created by YiLIU on 6/5/15.
 */
public class MaximumSumSubarray {
  public int maxSubArray(int[] nums) {
    int n = nums.length;
    int[] sum = new int[n];
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < n; ++i) {
      sum[i] = nums[i];
      sum[i] += i - 1 >= 0 && sum[i - 1] > 0 ? sum[i - 1] : 0;
      max = Math.max(max, sum[i]);
      }
    return max;
  }
}
