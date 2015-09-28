public class Solution{
  public void moveZeroes(int[] nums) {
    if (nums == null || nums.length == 0) {
      return;
    }
    int nonZero = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 0) {
        continue;
      }
      if (i != nonZero) {
        nums[nonZero] = nums[i];
      }
      nonZero++;
    }

    for (; nonZero < nums.length; nonZero++) {
      nums[nonZero] = 0;
    }
  }
}