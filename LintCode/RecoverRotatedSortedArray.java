/**
 * Rocover Rotated Sorted Array
 * http://www.lintcode.com/en/problem/recover-rotated-sorted-array/
 *
 * Given a rotated sorted array, recover it to sorted array in-place.
 *
 * Example
 * [4, 5, 1, 2, 3] -> [1, 2, 3, 4, 5]
 */
public class Solution {
  /**
   * @param nums: The rotated sorted array
   * @return: void
   */
  public void recoverRotatedSortedArray(ArrayList<Integer> nums) {
    // write your code
    if (nums == null || nums.size() == 0) {
      return;
    }
    int index = 0;
    for (int i = 1; i < nums.size(); ++i) {
      if (nums.get(i) < nums.get(i - 1)) {
        index = i;
        break;
      }
    }
    rotate(nums, 0, index);
    rotate(nums, index, nums.size());
    rotate(nums, 0, nums.size());
  }
  private void rotate(ArrayList<Integer> nums, int s, int e) {
    while (s < e - 1) {
      int temp = nums.get(e - 1);
      nums.set(e - 1, nums.get(s));
      nums.set(s, temp);
      s++;
      e--;
    }
  }
}