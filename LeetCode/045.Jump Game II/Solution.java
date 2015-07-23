public class Solution {
  public int jump(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    int max = 0;
    int end = 0;
    int step = 0;
    for (int i = 0; i < nums.length - 1; i++) {
      max = Math.max(max, nums[i] + i);
      if (i == end) {
        step++;
        end = max;
      }
    }

    return step;
  }
}