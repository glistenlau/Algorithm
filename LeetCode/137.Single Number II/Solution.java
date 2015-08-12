public class Solution {
  public int singleNumber(int[] nums) {
    if (nums == null || nums.length == 0) {
      return -1;
    }

    int[] bits = new int[32];
    int result = 0;

    for (int b = 0; b < 32; b++) {
      for (int i = 0; i < nums.length; i++) {
        bits[b] += (nums[i] >> b) & 1;
      }
      bits[b] %= 3;
      result |= bits[b] << b;
    }

    return result;
  }
}