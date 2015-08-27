class MyStack {
  Queue<Integer> q1 = new LinkedList<>();
  Queue<Integer> q2 = new LinkedList<>();
  boolean inQ2 = false;
  // Push element x onto stack.
  public void push(int x) {
    if (!inQ2) {
      q1.offer(x);
    } else {
      q2.offer(x);
    }
  }

  // Removes the element on top of the stack.
  public void pop() {
    if (!inQ2) {
      while (q1.size() > 1) {
        q2.offer(q1.poll());
      }
      inQ2 = true;
      q1.poll();
    } else {
      while (q2.size() > 1) {
        q1.offer(q2.poll());
      }
      q2.poll();
      inQ2 = false;
    }
  }

  // Get the top element.
  public int top() {
    if (!inQ2) {
      while (q1.size() > 1) {
        q2.offer(q1.poll());
      }
      return q1.peek();
    } else {
      while (q2.size() > 1) {
        q1.offer(q2.poll());
      }
      return q2.peek();
    }
  }

  // Return whether the stack is empty.
  public boolean empty() {
    return q1.isEmpty() && q2.isEmpty();
  }
}