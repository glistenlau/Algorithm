/**
 * Largest Rectangle in Histogram
 * www.lintcode.com/en/problem/largest-rectangle-in-histogram/
 *
 * Given n non-negative integers representing the histogram's bar height
 * where the width of each bar is 1, find the area of largest rectangle in
 * the histogram.
 */

public class Solution {
  /**
   * @param height: A list of integer
   * @return: The area of largest rectangle in the histogram
   */
  public int largestRectangleArea(int[] height) {
    if (height == null || height.length == 0) {
      return 0;
    }
    Stack<Integer> myStack = new Stack<Integer>();
    int max = 0;

    for (int i = 0; i <= height.length; i++) {
      int curt = i == height.length ? -1: height[i];
      while(!myStack.isEmpty() && curt <= height[myStack.peek()]) {
        int h = height[myStack.pop()];
        int w = myStack.isEmpty() ? i: i - 1 - myStack.peek();
        max = Math.max(max, h * w);
      }
      myStack.push(i);
    }

    return max;
  }
}

