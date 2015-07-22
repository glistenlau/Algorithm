public class Solution {
  private class resultType {
    char c;
    int index;
    public resultType(char c, int index) {
      this.c = c;
      this.index = index;
    }
  }

  public int longestValidParentheses(String s) {
    if (s == null || s.length() < 2) {
      return 0;
    }

    int longest = 0;
    Stack<resultType> myStack = new Stack<resultType>();

    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == ')') {
        if (myStack.isEmpty() || myStack.peek().c != '(') {
          myStack.push(new resultType(')', i));
        } else {
          resultType temp = myStack.pop();
          longest = Math.max(longest, myStack.isEmpty() ? i + 1 : i - myStack.peek().index);
        }
      } else {
        myStack.push(new resultType('(', i));
      }
    }

    return longest;
  }
}