public class Solution {
  public int removeDuplicates(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    int i = 0;
    int r = 0;

    while (i < nums.length) {
      if (i != 0 && nums[i] == nums[i - 1]) {
        i++;
        continue;
      }

      if (r != i) {
        nums[r] = nums[i];
      }
      r++;
      i++;
    }

    return r;
  }
}