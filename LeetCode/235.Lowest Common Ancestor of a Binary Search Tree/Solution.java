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
  boolean foundOne = false;
  boolean foundTwo = false;
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) {
      return null;
    }

    TreeNode left = lowestCommonAncestor(root.left, p, q);
    TreeNode right = lowestCommonAncestor(root.right, p, q);

    if (root == p || root == q) {
      if (foundOne) {
        foundTwo = true;
      } else {
        foundOne = true;
      }
      return root;
    }

    if (left != null && right != null) {
      return root;
    }

    if (left != null) {
      return left;
    }

    if (right != null) {
      return right;
    }

    return null;
  }
}