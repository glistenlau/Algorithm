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
  public int countNodes(TreeNode root) {
    if (root == null) {
      return 0;
    }

    int left = getLeftDepth(root);
    int right = getRightDepth(root);
    int ans = 0;
    if (left == right) {
      return (1 << left) - 1;
    } else {
      return countNodes(root.left) + countNodes(root.right) + 1;
    }
  }

  private int getLeftDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }

    return getLeftDepth(root.left) + 1;
  }

  private int getRightDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }

    return getRightDepth(root.right) + 1;
  }
}