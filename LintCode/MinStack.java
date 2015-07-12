/**
 * Min Stack
 * www.lintcode.com/en/problem/min-stack/
 *
 * Implement a stack with min() function, which will return the smallest
 * number in the stack.
 *
 * It should support push, pop and min operation all i O(1) cost.
 *
 * Example
 * Operations: push(1), pop(), push(2), push(3), min(), push(1), min() Return
 * 1, 2, 1.
 */

public class Solution {

  private Stack<Integer> stack1;
  private Stack<Integer> minStack;

  public Solution() {
    stack1 = new Stack<Integer>();
    minStack = new Stack<Integer>();
  }

  public void push(int element) {
    stack1.push(element);
    if (minStack.isEmpty()) {
      minStack.push(element);
    } else {
      minStack.push(Math.min(minStack.peek(), element));
    }
  }

  public int pop() {
    minStack.pop();
    return stack1.pop();
  }

  public int min() {
    return minStack.peek();
  }
}

