public class Solution {
  public int maxProduct(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    int max = nums[0];
    int min = nums[0];
    int maxAns = nums[0];

    for (int i = 1; i < n; ++i) {
      int mx = max;
      max = Math.max(Math.max(max * nums[i], nums[i]), min * nums[i]);
      min = Math.min(Math.min(min * nums[i], nums[i]), mx * nums[i]);
      maxAns = Math.max(max, maxAns);
    }
    return maxAns;
  }
}