/**
 * Valid Parentheses
 * www.lintcode.com/en/problem/valid-parentheses/
 *
 * Given a string containing just the characters '(', ')', '{', '}', '[', ']', determine if the input
 * string is valid.
 *
 * Example
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 *
 */
public class Solution {
  /**
   * @param s A string
   * @return whether the string is a valid parentheses
   */
  public boolean isValidParentheses(String s) {
    if (s == null || s.length() == 0) {
      return true;
    }

    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == ')' || c == '}' || c==']') {
        if (stack.isEmpty() || !isValid(stack.pop(), c)) {
          return false;
        }
      } else {
        stack.push(c);
      }
    }

    return stack.isEmpty();
  }

  private boolean isValid(char first, char last) {
    if (first == '(') {
      return last == ')';
    } else if (first == '{') {
      return last == '}';
    } else if (first == '[') {
      return last == ']';
    }
    return false;
  }

}
