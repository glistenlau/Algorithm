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
  public int kthSmallest(TreeNode root, int k) {
    if (root == null || k == 0) {
      return -1;
    }

    int[] ans = new int[]{k, -1};

    find(root, ans);
    return ans[1];
  }

  private void find(TreeNode root, int[] para) {
    if (root == null) {
      return;
    }

    find(root.left, para);

    if (--para[0] == 0) {
      para[1] = root.val;
    }

    find(root.right, para);
  }
}