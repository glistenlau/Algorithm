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
  public boolean isBalanced(TreeNode root) {
    return depth(root) != -1;
  }

  private int depth(TreeNode root) {
    if (root == null) {
      return 0;
    }

    int left = depth(root.left);
    int right = depth(root.right);

    if (left == -1 || right == -1) {
      return -1;
    }

    return Math.abs(left - right) < 2? Math.max(left, right) + 1: -1;
  }
}