/**
 * Implement Queue by Two Stacks
 * www.lintcode.com/en/problem/implement-queue-by-two-stacks/
 *
 * As the title described, you should only use two stacks to implement a
 * queeu's actions.
 *
 * The queue should support push(element), pop() and top() where pop is pop
 * the first(a.k.a front) element int the queue.
 *
 * Both pop and top method should return the value of first element.
 *
 * Example
 * For push(1), pop(), push(2), push(3), top(), pop(), you should return 1, 2
 * and 2.
 */

public class Solution {
  private Stack<Integer> stack1;
  private Stack<Integer> stack2;

  public Solution() {
    stack1 = new Stack<Integer>();
    stack2 = new Stack<Integer>();
  }

  //O(1)
  public void push(int element) {
    stack1.push(element);
  }

  //Average O(1)
  public int pop() {
    if (stack2.isEmpty()) {
      while(!stack1.isEmpty()){
        stack2.push(stack1.pop());
      }
    }
    return stack2.pop();
  }

  //Average O(1)
  public int top() {
    if (stack2.isEmpty()) {
      while(!stack1.isEmpty()){
        stack2.push(stack1.pop());
      }
    }
    return stack2.peek();
  }
}