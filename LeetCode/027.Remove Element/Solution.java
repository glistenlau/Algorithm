public class Solution {
  public int removeElement(int[] nums, int val) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    int i = 0;
    int r = 0;

    while (i < nums.length) {
      if (nums[i] == val) {
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