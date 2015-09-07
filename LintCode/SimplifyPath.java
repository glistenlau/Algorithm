/**
 * Simplify Path
 * www.lintcode.com/en/problem/simplify-path/
 *
 * Given an absolute path for a file(Unix-style), simplify it.
 * Example
 * "/home/", => "/home"
 * "/a/./b/../../c/", => "/c";
 */
public class Solution {
  /**
   * @param path the original path
   * @return the simplified path
   */
  public String simplifyPath(String path) {
    if (path == null || path.length() == 0) {
      return "/";
    }

    Stack<String> folder = new Stack<>();
    String[] folders = path.split("/");
    for (String f: folders) {
      if (f.equals(".")) {
        folder = new Stack<>();
      } else if (f.equals("..")) {
        if (!folder.isEmpty()) {
          folder.pop();
        }
      } else if (f.length() > 0) {
        folder.push(f);
      }
    }

    StringBuilder ans = new StringBuilder();
    while (!folder.isEmpty()) {
      ans.insert(0, folder.pop());
      ans.insert(0, '/');
    }
    if (ans.length() == 0) {
      return "/";
    }
    return ans.toString();
  }
}
