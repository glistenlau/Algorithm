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
  public TreeNode buildTree(int[] preorder, int[] inorder) {
    return buildTree(preorder, 0, inorder, 0, inorder.length - 1);
  }

  private TreeNode buildTree(int[] pre, int pos, int[] in, int s, int e) {
    if (pos >= pre.length || s > e) {
      return null;
    }
    TreeNode root = new TreeNode(pre[pos]);
    int i = s;

    for ( ; i <= e; i++) {
      if (in[i] == pre[pos]) {
        break;
      }
    }

    root.left = buildTree(pre, pos + 1, in, s, i - 1);
    root.right = buildTree(pre,pos + i - s + 1, in, i + 1, e);

    return root;
  }
}