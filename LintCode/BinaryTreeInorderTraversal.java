/**
 * Binary Tree Inorder Traversal
 * http://www.lintcode.com/en/problem/binary-tree-inorder-traversal/
 *
 * Given a binary tree, return the inorder traversal of its nodes' values.
 *
 * Example
 * Given binary tree {1,#,2,3},
 * 1
 *  \
 *   2
 *  /
 * 3
 * return [1,3,2].
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
   * @param root: The root of binary tree.
   * @return: Inorder in ArrayList which contains node values.
   */
  public ArrayList<Integer> inorderTraversal(TreeNode root) {
    // write your code here
    ArrayList<Integer> result = new ArrayList<Integer>();
    Stack<TreeNode> save = new Stack<TreeNode>();
    if (root == null) {
      return result;
    }
    TreeNode cur = root;
    while (!save.empty() || cur != null) {
      while (cur != null) {
        save.add(cur);
        cur = cur.left;
      }
      cur = save.pop();
      result.add(cur.val);
      cur = cur.right;
    }
    return result;
  }
}