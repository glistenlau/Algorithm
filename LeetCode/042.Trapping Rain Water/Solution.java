public class Solution {
  public int trap(int[] height) {
    if (height == null || height.length == 0) {
      return 0;
    }

    int result = 0;
    Stack<Integer> myStack = new Stack<Integer>();

    for (int i = 0; i < height.length; i++) {
      if (myStack.isEmpty()) {
        myStack.push(i);
        continue;
      }
      if (height[i] < height[myStack.peek()]) {
        myStack.push(i);
      }
      while (!myStack.isEmpty() && height[i] > height[myStack.peek()]){
        int right = myStack.pop();
        while(!myStack.isEmpty() && height[myStack.peek()] == height[right]) {
          myStack.pop();
        }
        if (!myStack.isEmpty()) {
          int left = myStack.peek();
          int h = Math.min(height[i], height[left]) - height[right];
          int w = i - left - 1;
          result += h * w;
        }
      }
      myStack.push(i);
    }
    return result;
  }
}