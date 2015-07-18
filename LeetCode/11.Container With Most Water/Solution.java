public class Solution {
  public int maxArea(int[] height) {
    if (height == null || height.length == 0) {
      return 0;
    }

    int left = 0;
    int right = height.length - 1;
    int result = 0;

    while (left < right) {
      int area = 0;
      if (height[left] < height[right]) {
        area = height[left] * (right - left);
        left++;
      } else {
        area = height[right] * (right - left);
        right--;
      }

      result = Math.max(result, area);
    }

    return result;
  }
}