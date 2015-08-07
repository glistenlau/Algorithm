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
  private class ResultType{
    int lineMax;
    int max;
    public ResultType(int lineMax, int max) {
      this.lineMax = lineMax;
      this.max = max;
    }
  }

  public int maxPathSum(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return pathSum(root).max;
  }

  private ResultType pathSum(TreeNode root) {
    if (root == null) {
      return new ResultType(0, Integer.MIN_VALUE);
    }

    ResultType left = pathSum(root.left);
    ResultType right = pathSum(root.right);

    int lineSum = Math.max(root.val, root.val + Math.max(left.lineMax, right.lineMax));
    int max = root.val + (left.lineMax > 0? left.lineMax: 0) + (right.lineMax > 0? right.lineMax: 0);

    max = Math.max(max, Math.max(left.max, right.max));

    return new ResultType(lineSum, max);
  }
}