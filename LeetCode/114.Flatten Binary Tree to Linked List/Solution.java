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
  public void flatten(TreeNode root) {
    flattenHelper(root);
  }

  public TreeNode flattenHelper(TreeNode root) {
    if (root == null) {
      return null;
    }

    TreeNode left = flattenHelper(root.left);
    TreeNode right = flattenHelper(root.right);
    if (left != null && right != null) {
      left.right = root.right;
      root.right = root.left;
      root.left = null;
      return right;
    } else if (left != null) {
      root.right = root.left;
      root.left = null;
      return left;
    } else if (right != null) {
      return right;
    } else {
      return root;
    }
  }
}