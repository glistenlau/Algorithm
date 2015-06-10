/**
 * Created by YiLIU on 6/9/15.
 */
public class MaximumProductSubarray {
  public int maxProduct(int[] nums) {
    int n = nums.length;
    if (n < 1) return 0;
    int max = nums[0];
    int min = nums[0];
    int maxAns = nums[0];
    for (int i = 1; i < n; ++i) {
      int mx = max, mn = min;
      max = Math.max(Math.max(mx * nums[i], nums[i]), mn * nums[i]);
      min = Math.min(Math.min(mn * nums[i], nums[i]), mx * nums[i]);
      maxAns = Math.max(max, maxAns);
    }
    return maxAns;
  }

  public static void main (String[] args) {
    int[] test = {-2, -3, -4};
    System.out.println(new MaximumProductSubarray().maxProduct(test));
  }
}
