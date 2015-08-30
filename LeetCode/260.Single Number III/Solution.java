public class Solution {
  public int[] singleNumber(int[] nums) {
    int[] ans = new int[2];
    if (nums == null || nums.length < 3) {
      return nums;
    }

    int combine = 0;
    for (int num: nums) {
      combine ^= num;
    }

    combine = (combine - ((combine - 1) & combine));

    for (int num: nums) {
      if ((combine & num) == 0) {
        ans[0] ^= num;
      } else {
        ans[1] ^= num;
      }
    }

    return ans;
  }
}