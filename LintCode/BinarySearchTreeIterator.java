/**
 * Binary Search Tree Iterator
 * http://www.lintcode.com/en/problem/binary-search-tree-iterator/
 *
 * Design an iterator over a binary search tree with the following rules:
 *
 *   Elements are visited in ascending order (i.e. an in-order traversal)
 *
 *   next() and hasNext() queries run in O(1) time in average.
 *
 * Example
 * For the following binary search tree, in-order traversal by using iterator
 *  is [1, 6, 10, 11, 12]
 *     10
 *   /    \
 *  1      11
 *   \       \
 *   6       12
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
 * Example of iterate a tree:
 * Solution iterator = new Solution(root);
 * while (iterator.hasNext()) {
 *    TreeNode node = iterator.next();
 *    do something for node
 * }
 */
public class Solution {
  //@param root: The root of binary tree.
  private Stack<TreeNode> save = new Stack<TreeNode>();
  private TreeNode cur;

  public Solution(TreeNode root) {
    // write your code here
    cur = root;
  }

  //@return: True if there has next node, or false
  public boolean hasNext() {
    // write your code here
    return cur != null || save.size() != 0;
  }

  //@return: return next node
  public TreeNode next() {
    // write your code her
    while (cur != null) {
      save.push(cur);
      cur = cur.left;
    }
    cur = save.pop();
    TreeNode temp = cur;
    cur = cur.right;
    return temp;
  }
}