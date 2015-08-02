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
  public TreeNode buildTree(int[] inorder, int[] postorder) {
    return buildTree(inorder, 0, inorder.length - 1, postorder, postorder.length - 1);
  }

  private TreeNode buildTree(int[] in, int s, int e, int[] post, int pos) {
    if (s > e || pos < 0) {
      return null;
    }

    TreeNode root = new TreeNode(post[pos]);

    int i = s;
    for ( ; i <= e; i++) {
      if (in[i] == post[pos]) {
        break;
      }
    }

    root.right = buildTree(in, i + 1, e, post, pos - 1);
    root.left = buildTree(in, s, i - 1, post, pos - e + i -1);

    return root;
  }
}