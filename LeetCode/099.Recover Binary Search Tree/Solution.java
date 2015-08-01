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
  public void recoverTree(TreeNode root) {
    TreeNode[] pack = new TreeNode[3];
    pack[0] = null;
    pack[1] = null;
    pack[2] = new TreeNode(Integer.MIN_VALUE);
    recoverTree(root, pack);
    int temp = pack[0].val;
    pack[0].val = pack[1].val;
    pack[1].val = temp;
  }

  private void recoverTree(TreeNode root, TreeNode[] pack) {
    if (root == null) {
      return;
    }
    recoverTree(root.left, pack);
    if (pack[0] == null && root.val < pack[2].val) {
      pack[0] = pack[2];
    }
    if (pack[0] != null && root.val < pack[2].val) {
      pack[1] = root;
    }
    pack[2] = root;
    recoverTree(root.right, pack);
  }
}