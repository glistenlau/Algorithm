/**
 * Subtree
 * www.lintcode.com/en/problem/subtree/
 *
 * You have two every large binary trees: T1, with millions of nodes, and T2, with
 * hundreds of nodes. Create an algorithm to decide if T2 is a subtree of T1.
 *
 * Example
 * T2 is a substree of T1 in the following case:
 *   T2:      1         T1:     3
 *          /  \              /
 *         2    3           4
 *             /
 *            4
 * T2 isn't a subtree of T1 in the following case:
 *   T2:      1         T1:     3
 *          /  \                 \
 *         2    3                 4
 *             /
 *            4
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
   * @param T1, T2: The roots of binary tree.
   * @return: True if T2 is a subtree of T1, or false.
   */
  public boolean isSubtree(TreeNode T1, TreeNode T2) {
    if (T2 == null) {
      return true;
    }
    return hasSubtree(T1, T2);
  }

  public boolean hasSubtree(TreeNode T1, TreeNode T2) {
    // write your code here
    if (T1 == null && T2 == null) {
      return true;
    }
    if (T1 == null || T2 == null) {
      return false;
    }

    if (T1.val == T2.val) {
      if (hasSubtree(T1.left, T2.left) && hasSubtree(T1.right, T2.right)) {
        return true;
      }
    }
    return hasSubtree(T1.left, T2) || hasSubtree(T1.right, T2);
  }
}
