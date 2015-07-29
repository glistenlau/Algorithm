public class Solution {
  public int largestRectangleArea(int[] height) {
    if (height == null || height.length == 0) {
      return 0;
    }
    int maxArea = 0;
    Stack<Integer> myStack = new Stack<Integer>();

    for (int i = 0; i <= height.length; i++) {
      int aft = i == height.length? Integer.MIN_VALUE: height[i];
      while(!myStack.isEmpty() && height[myStack.peek()] > aft) {
        int h = height[myStack.pop()];
        int w = myStack.isEmpty()? i: i - 1 - myStack.peek();
        maxArea = Math.max(maxArea, h * w);
      }
      myStack.push(i);
    }

    return maxArea;
  }
}