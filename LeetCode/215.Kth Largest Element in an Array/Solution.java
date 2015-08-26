public class Solution {
  public int findKthLargest(int[] nums, int k) {
    return quickSelect(nums, k, 0, nums.length - 1);
  }

  private int quickSelect(int[] nums, int k, int left, int right) {
    if (left >= right) {
      return nums[left];
    }

    int p = nums[left + (right - left) / 2];
    int l = left;
    int r = right;

    while (l <= r) {
      while (l <= r && nums[l] > p) {
        l++;
      }
      while (l <= r && nums[r] < p) {
        r--;
      }

      if (l <= r) {
        swap(nums, l, r);
        l++;
        r--;
      }
    }

    if (r + 1 >= k) {
      return quickSelect(nums, k, left, r);
    }
    if (l + 1 <= k) {
      return quickSelect(nums, k, l, right);
    }
    return nums[k - 1];
  }

  private void swap(int[] nums, int a, int b) {
    int temp = nums[a];
    nums[a] = nums[b];
    nums[b] = temp;
  }
}