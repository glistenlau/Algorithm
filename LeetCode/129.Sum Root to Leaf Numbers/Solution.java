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
  public int sumNumbers(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return sumTree(root, 0);
  }

  private int sumTree(TreeNode root, int sum) {
    if (root == null) {
      return 0;
    }

    sum *= 10;
    sum += root.val;
    if (root.left == null && root.right == null) {
      return sum;
    }

    return sumTree(root.left, sum) + sumTree(root.right, sum);
  }
}