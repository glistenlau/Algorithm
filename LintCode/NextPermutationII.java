/**
 * Next Permutation II
 * www.lintcode.com/en/problem/next-permutation-ii/
 *
 * Implement next permutation, which rearanges numbers into the lexicographically next
 * greater permutation of numbers.
 *
 * If such arrangement is not possible, it must rearrange it as the lowest possible order.
 *
 * Example
 * 1, 2, 3 -> 1, 3, 2
 * 3, 2, 1 -> 1, 2, 3
 * 1, 1, 5 -> 1, 5, 1
 */
public class Solution {
  /**
   * @param nums: an array of integers
   * @return: return nothing (void), do not return anything, modify nums in-place instead
   */
  public void nextPermutation(int[] nums) {
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
  }

  private void swap(int[] nums, int a, int b) {
    int temp = nums[a];
    nums[a] = nums[b];
    nums[b] = temp;
  }

  private void reverse(int[] nums, int left, int right) {
    while (left < right) {
      swap(nums, left++, right--);
    }
  }
}
