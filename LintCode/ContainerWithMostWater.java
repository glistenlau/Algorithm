/**
 * Container With Most Water
 * www.lintcode.com/en/problem/container-with-most-water/
 *
 * Given n non-negtive integers a1, a2, ..., an, where each represents a point at coordinate(1, ai).
 * n vertival lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find
 * two lines, which together with x-axis forms a contianer, such that the container contains the most
 * water.
 *
 * Example
 * Given [1, 3, 2], the max area of the container is 2.
 */
public class Solution {
  /**
   * @param heights: an array of integers
   * @return: an integer
   */
  public int maxArea(int[] heights) {
    // write your code here
    if (heights == null || heights.length == 0) {
      return 0;
    }
    int ans = 0;
    int left = 0;
    int right = heights.length - 1;
    while (left < right) {
      int area = Math.min(heights[left], heights[right]) * (right - left);
      ans = Math.max(area, ans);
      if (heights[left] <= heights[right]) {
        left++;
      } else {
        right--;
      }
    }

    return ans;
  }
}
