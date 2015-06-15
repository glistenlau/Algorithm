/**
 * Created by YiLIU on 6/14/15.
 */
public class ContainerWithMostWater {
  public int maxArea(int[] height) {
    int max = 0;
    int left = 0;
    int right = height.length - 1;
      while (left < right) {
        if (height[left] < height[right]) {
          max = Math.max(max, height[left] * (right - left));
          ++left;
        } else {
          max = Math.max(max, height[right] * (right - left));
          --right;
        }
      }
    return max;
  }
}
