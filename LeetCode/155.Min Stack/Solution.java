class MinStack {
  Stack<Integer> stack = new Stack<>();
  Stack<Integer> minStack = new Stack<>();
  public void push(int x) {
    stack.push(x);
    minStack.push(minStack.isEmpty() || x < minStack.peek()? x: minStack.peek());
  }

  public void pop() {
    stack.pop();
    minStack.pop();
  }

  public int top() {
    return stack.peek();
  }

  public int getMin() {
    return minStack.peek();
  }
}
