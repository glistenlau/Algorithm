public class Solution {
  public int threeSumClosest(int[] nums, int target) {
    if (nums == null || nums.length < 3) {
      return 0;
    }
    Arrays.sort(nums);
    int result = nums[0] + nums[1] + nums[2];

    for (int i = 0; i < nums.length; i++) {
      int left = i + 1;
      int right = nums.length - 1;

      while (left < right) {
        int sum = nums[i] + nums[left] + nums[right];
        result = Math.abs(target - sum) < Math.abs(target - result) ? sum : result;
        if (sum == target) {
          return sum;
        } else if (sum > target) {
          right--;
        } else {
          left++;
        }
      }

    }

    return result;
  }
}