/**
 * Construct Binary Tree from Preorder and Inorder Traversal
 * http://www.lintcode.com/en/problem/construct-binary-tree-from-preorder-and
 * -inorder-traversal/
 *
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 *
 * Example
 * Given in-order [1,2,3] and pre-order [2,1,3], return a tree:
 *   2
 *  / \
 * 1   3
 *
 * Note
 * You may assume that duplicates do not exist in the tree.
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
  *@param preorder : A list of integers that preorder traversal of a tree
  *@param inorder : A list of integers that inorder traversal of a tree
  *@return : Root of a tree
  */
 public TreeNode buildTree(int[] preorder, int[] inorder) {
  // write your code here
  return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
 }

 private int find(int[] arr, int s, int e, int key) {
  for (int i = s; i <= e; i++) {
   if (arr[i] == key) {
    return i;
   }
  }
  return -1;
 }

 private TreeNode build(int[] pre, int ps, int pe, int[] in, int is, int ie) {
  if (is > ie) {
   return null;
  }
  TreeNode root = new TreeNode(pre[ps]);
  int pos = find(in, is, ie, pre[ps]);

  root.left = build(pre, ps + 1, ps + pos - is, in, is, pos - 1);
  root.right = build(pre, pe - (ie - pos) + 1, pe, in, pos + 1, ie);

  return root;
 }
}