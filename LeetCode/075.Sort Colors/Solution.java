public class Solution {
  public void sortColors(int[] nums) {
    if (nums == null || nums.length == 0) {
      return;
    }

    int i = quickSort(nums, 0, nums.length, 0);
    quickSort(nums, i, nums.length, 1);
  }

  private int quickSort(int[] nums, int s, int e, int tar) {
    int left = s;
    int right = e - 1;

    while( left <= right) {
      while(left <= right && nums[left] <= tar) {
        left++;
      }
      while (left <= right && nums[right] > tar) {
        right--;
      }

      if (left < right) {
        swap(nums, left, right);
        left ++;
        right --;
      }
    }

    return left;
  }

  private void swap(int[] nums, int l, int r) {
    int temp = nums[l];
    nums[l] = nums[r];
    nums[r] = temp;
  }
}