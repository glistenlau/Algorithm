/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
  public List<String> binaryTreePaths(TreeNode root) {
    List<String> ans = new ArrayList<String>();
    if (root == null) {
      return ans;
    }

    dfsHelper(root, new StringBuilder(), ans);
    return ans;
  }

  private void dfsHelper(TreeNode root, StringBuilder taken, List<String> ans) {
    if (root == null) {
      return;
    }

    if (taken.length() > 0) {
      taken.append("->");
    }
    taken.append(root.val);

    if (root.left == null && root.right == null) {
      ans.add(taken.toString());
    } else {
      dfsHelper(root.left, taken, ans);
      dfsHelper(root.right, taken, ans);
    }

    taken.delete(taken.lastIndexOf("" + root.val), taken.length());
    if (taken.length() > 2 && taken.substring(taken.length() - 2).equals("->")) {
      taken.delete(taken.length() - 2, taken.length());
    }
  }
}