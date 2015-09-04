/**
 * Previous Permutation
 * www.lintcode.com/en/problem/previous-permutation/
 *
 * Given a list of integers, which denote a permutation.
 * Find the prevois permutaion in ascending order.
 *
 * Example
 * For [1, 3, 2, 3], the previous permutation is [1, 2, 3, 3].
 * For [1, 2, 3, 4], the previous permutation is [4, 3, 2, 1].
 */
public class Solution {
  /**
   * @param nums: A list of integers
   * @return: A list of integers that's previous permuation
   */
  public ArrayList<Integer> previousPermuation(ArrayList<Integer> nums) {
    // write your code
    if (nums == null || nums.size() == 0) {
      return new ArrayList<Integer>();
    }

    int index = -1;
    for (int i = nums.size() - 2; i >= 0; i--) {
      if (nums.get(i) > nums.get(i + 1)) {
        index = i;
        break;
      }
    }
    if (index != -1) {
      for (int i = nums.size() - 1; i > index; i--) {
        if (nums.get(i) < nums.get(index)) {
          swap(nums, i, index);
          break;
        }
      }
    }
    reverse(nums, index + 1, nums.size() - 1);
    return nums;
  }

  private void swap(ArrayList<Integer> nums, int a, int b) {
    int temp = nums.get(a);
    nums.set(a, nums.get(b));
    nums.set(b, temp);
  }

  private void reverse(ArrayList<Integer> nums, int s, int e) {
    while (s < e) {
      swap(nums, s++, e--);
    }
  }
}

