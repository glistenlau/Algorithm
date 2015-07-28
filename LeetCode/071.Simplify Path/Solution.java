public class Solution {
  public String simplifyPath(String path) {
    if (path == null || path.length() == 0) {
      return null;
    }

    StringBuilder result = new StringBuilder();
    String[] paths = path.split("/");
    Stack<String> myStack = new Stack<String>();
    for (String s: paths) {
      if (".".equals(s) || "".equals(s)) {
        continue;
      } else if ("..".equals(s)) {
        if (!myStack.isEmpty()) {
          myStack.pop();
        }
      } else {
        myStack.push(s);
      }
    }

    if (myStack.isEmpty()) {
      result.append("/");
    }

    while (!myStack.isEmpty()) {
      result.insert(0, myStack.pop());
      result.insert(0, "/");
    }

    return result.toString();
  }
}