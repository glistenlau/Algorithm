/**
 * Next Permutation
 * www.lintcode.com/en/problem/next-permutation/
 *
 * Given a list of integers, which denote a permutation.
 *
 * Find the next permutation in ascending order.
 *
 * Example
 * For [1, 3, 2, 3], the next permutation is [1, 3, 3, 2].
 * For [4, 3, 2, 1], the next permutation is [1, 2, 3, 4].
 */
public class Solution {
  /**
   * @param nums: an array of integers
   * @return: return nothing (void), do not return anything, modify nums in-place instead
   */
  public int[] nextPermutation(int[] nums) {
    // write your code here
    if (nums == null || nums.length == 0) {
      return new int[0];
    }

    int index = -1;
    for (int i = nums.length - 2; i >= 0; i--) {
      if (nums[i] < nums[i + 1]) {
        index = i;
        break;
      }
    }

    if (index != -1) {
      for (int i = nums.length - 1; i > index; i--) {
        if (nums[i] > nums[index]) {
          swap(nums, index, i);
          break;
        }
      }
    }

    reverse(nums, index + 1, nums.length - 1);
    return nums;
  }

  private void reverse(int[] nums, int left, int right) {
    while (left < right) {
      swap(nums, left++, right--);
    }
  }

  private void swap(int[] nums, int a, int b) {
    int temp = nums[a];
    nums[a] = nums[b];
    nums[b] = temp;
  }
}
