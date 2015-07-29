public class Solution {
  public int removeDuplicates(int[] nums) {
    if ( nums.length < 3) {
      return nums.length;
    }

    int r = 2;
    int pre = nums[1];
    int prePre = nums[0];

    for (int i = 2; i < nums.length; i++) {
      if (nums[i] == pre && nums[i] == prePre) {
        continue;
      }
      if (r != i) {
        nums[r] = nums[i];
      }
      prePre = pre;
      pre = nums[i];
      r++;
    }

    return r;
  }
}