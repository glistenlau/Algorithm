public class Solution {
  public boolean isValid(String s) {
    if (s == null || s.length() == 0) {
      return true;
    }

    HashMap<Character, Character> lookup = new HashMap<Character, Character>();

    lookup.put(')', '(');
    lookup.put('}', '{');
    lookup.put(']', '[');
    Stack<Character> myStack = new Stack<Character>();

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (lookup.containsKey(c)) {
        if (myStack.isEmpty() || lookup.get(c) != myStack.pop()) {
          return false;
        }
      } else {
        myStack.push(c);
      }
    }

    return myStack.isEmpty();
  }
}