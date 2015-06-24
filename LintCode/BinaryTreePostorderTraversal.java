/**
 * Binary Tree Postorder Traversal
 * http://www.lintcode.com/en/problem/binary-tree-postorder-traversal/
 *
 * Given a binary tree, return the postorder traversal of its nodes' values.
 *
 * Example
 * Given binary tree {1,#,2,3},
 * 1
 *  \
 *   2
 *  /
 * 3
 * return [3,2,1].
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
   * @return: Postorder in ArrayList which contains node values.
   */

  // Recursion
  public ArrayList<Integer> postorderTraversal(TreeNode root) {
    // write your code here
    ArrayList<Integer> result = new ArrayList<Integer>();
    helper(root, result);
    return result;
  }

  private void helper(TreeNode root, ArrayList<Integer> result) {
    if (root == null) {
      return;
    }

    helper(root.left, result);
    helper(root.right, result);
    result.add(root.val);
  }

  // Iterative
  public ArrayList<Integer> postorderTraversal(TreeNode root) {
    // write your code here
    ArrayList<Integer> result = new ArrayList<Integer>();
    Stack<TreeNode> save = new Stack<TreeNode>();
    if (root == null) {
      return result;
    }
    save.push(root);
    TreeNode pre = null;
    while (!save.empty()) {
      TreeNode cur = save.peek();
      if (pre == null || cur == pre.left || cur == pre.right) {
        if (cur.left != null) {
          save.push(cur.left);
        } else if (cur.right != null) {
          save.push(cur.right);
        }
      } else if (cur.left == pre) {
        if (cur.right != null) {
          save.push(cur.right);
        }
      } else {
        result.add(cur.val);
        save.pop();
      }
      pre = cur;
    }
    return result;
  }
}