public class Solution {
  public void nextPermutation(int[] nums) {
    if (nums == null || nums.length == 0) {
      return;
    }

    int r = nums.length - 1;
    while (r > 0 && nums[r] <= nums[r - 1]) {
      r--;
    }

    int l = r > 0 ? r - 1: nums.length - 1;
    int firstGreat = nums.length - 1;

    while (firstGreat > r && firstGreat > l && nums[firstGreat] <= nums[l]) {
      firstGreat--;
    }

    swap(nums, l, firstGreat);
    reverse(nums, r, nums.length - 1);
  }

  private void swap(int[] nums, int a, int b) {
    int temp = nums[a];
    nums[a] = nums[b];
    nums[b] = temp;
  }

  private void reverse(int[] nums, int s, int e) {
    while (s < e) {
      swap(nums, s, e);
      s++;
      e--;
    }
  }
}