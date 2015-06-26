/**
 * Construct Binary Tree from Inorder and Postorder Traversal
 * http://www.lintcode.com/en/problem/construct-binary-tree-from-inorder-and-postorder-traversal/
 *
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 *
 * Example
 * Given inorder [1,2,3] and postorder [1,3,2], return a tree:
 *   2
 *  / \
 * 1   3
 */

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */


public class Solution {
  /**
   *@param inorder : A list of integers that inorder traversal of a tree
   *@param postorder : A list of integers that postorder traversal of a tree
   *@return : Root of a tree
   */
  public TreeNode buildTree(int[] inorder, int[] postorder) {
    // write your code here
    return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
  }

  private TreeNode build(int[] inorder, int is, int ie, int[] postorder, int ps, int pe) {
    if (is > ie) {
      return null;
    }

    TreeNode root = new TreeNode(postorder[pe]) ;
    int pos = find(inorder, is, ie, postorder[pe]);

    root.left = build(inorder, is, pos - 1, postorder, ps, ps + pos - is - 1);
    root.right = build(inorder, pos + 1, ie, postorder, ps + pos - is, pe - 1);

    return root;
  }

  private int find(int[] arr, int s, int e, int key) {
    for (int i = s; i <= e; i++) {
      if (arr[i] == key) {
        return i;
      }
    }
    return -1;
  }
}