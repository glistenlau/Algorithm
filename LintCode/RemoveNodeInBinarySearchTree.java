/**
 * Remove Node in Binary Search Tree
 * http://www.lintcode.com/en/problem/remove-node-in-binary-search-tree/
 *
 * Given a root of Binary Search Tree with unique value for each node.
 * Remove the node with given value. If there is no such a node with given
 * value in the binary search tree, do nothing. You should keep the tree
 * still a binary search tree after removal.
 *
 * Example
 * Given binary search tree:
 *           5
 *        /    \
 *      3       6
 *   /    \
 * 2       4
 *
 * Remove 3, you can either return:
 *
 *      5
 *   /    \
 * 2        6
 *  \
 *   4
 * or :
 *          5
 *       /    \
 *     4       6
 *   /
 * 2
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
   * @param root: The root of the binary search tree.
   * @param value: Remove the node with given value.
   * @return: The root of the binary search tree after removal.
   */
  public TreeNode removeNode(TreeNode root, int value) {
    // write your code here
    if (root == null) {
      return null;
    }

    if (root.val == value) {
      if (root.left != null && root.right != null) {
        TreeNode swap = findMax(root.left);
        if (swap.left != null) {
          swap.left = removeNode(root.left, swap.val);
          swap.right = root.right;
        } else {
          swap.left = removeNode(root.left, swap.val);
          swap.right = root.right;
        }
        return swap;
      } else if (root.left != null) {
        return root.left;
      } else if (root.right != null) {
        return root.right;
      } else {
        return null;
      }
    }

    root.left = removeNode(root.left, value);
    root.right = removeNode(root.right, value);

    return root;
  }

  private TreeNode findMax(TreeNode root) {
    if (root == null || root.right == null) {
      return root;
    }

    return findMax(root.right);
  }
}