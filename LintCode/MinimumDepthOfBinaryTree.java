/**
 * Minimum Depth Of Binary Tree
 * http://www.lintcode.com/en/problem/minimum-depth-of-binary-tree/
 *
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the
 * root node down to the nearest leaf node.
 *
 * Example
 * Given a binary tree as follow:
 *
 *     1
 *  /     \
 * 2       3
 *      /    \
 *     4      5
 * The minimum depth is 2
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
   * @return: An integer.
   */
  public int minDepth(TreeNode root) {
    // write your code here
    if (root == null) {
      return 0;
    }
    int left = minDepth(root.left) + 1;
    int right = minDepth(root.right) + 1;
    if (root.left != null && root.right != null) {
      return Math.min(left, right);
    }
    if (root.left != null) {
      return left;
    }
    if (root.right != null) {
      return right;
    }
    return 1;
  }
}