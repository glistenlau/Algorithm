/**
 * Trapping Rain Water
 * www.lintcode.com/en/problem/trapping-rain-water/
 *
 * Given n non-ngetive integers representing an elevation map where the width of each bar is 1, compute how much water
 * it is able to trap after raining.
 *
 * Example
 * Given [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1], return 6.
 */
public class Solution {
  /**
   * @param heights: an array of integers
   * @return: a integer
   */
  public int trapRainWater(int[] heights) {
    if (heights == null || heights.length == 0) {
      return 0;
    }

    int left = 0;
    int right = heights.length - 1;
    int lower = Integer.MIN_VALUE;
    int result = 0;
    while (left < right) {
      if (heights[left] <= heights[right]) {
        if (heights[left] > lower) {
          lower = heights[left];
        } else {
          result += lower - heights[left];
        }
        left++;
      } else {
        if (heights[right] > lower) {
          lower = heights[right];
        } else {
          result += lower - heights[right];
        }
        right--;
      }
    }

    return result;
  }
}
