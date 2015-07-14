/**
 * Sort Colors II
 * www.lintcode.com/en/problem/sort-colors-ii/
 *
 * Given an array of n objects with k different colors (numbered from 1 to k)
 * sort them so that objects of the same color are adjacent, with the colors
 * in the order 1, 2, ...k.
 *
 * Example
 * Given colors = [3, 2, 2, 1, 4], k = 4, your code should sort colors
 * in-place to [1, 2, 2, 3, 4].
 */

class Solution {
  /**
   * @param colors: A list of integer
   * @param k: An integer
   * @return: nothing
   */
  public void sortColors2(int[] colors, int k) {
    if (colors == null || colors.length == 0) {
      return;
    }
    int start = 0;
    for (int i = 1; i <= k; i++) {
      start = quickSort(colors, i, start);
    }
  }

  private int quickSort(int[] colors, int target, int start) {
    int left = start;
    int right = colors.length - 1;
    while (left <= right) {
      while (left <= right && colors[left] == target) {
        left++;
      }
      while (left <= right && colors[right] > target) {
        right--;
      }
      if (left <= right) {
        int temp = colors[left];
        colors[left] = colors[right];
        colors[right] = temp;
      }
    }
    return left;
  }
}
