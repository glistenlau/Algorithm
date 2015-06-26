/**
 * Binary Tree Zigzag Level Order Traversal
 * http://www.lintcode.com/en/problem/binary-tree-zigzag-level-order-traversal/
 *
 * Given a binary tree, return the zigzag level order traversal of its nodes'
 * values. (ie, from left to right, then right to left for the next level and
 * alternate between).
 *
 * Example
 * Given binary tree {3,9,20,#,#,15,7},
 *   3
 *  / \
 * 9  20
 *   /  \
 * 15   7
 * return its zigzag level order traversal as:
 * [
 *  [3],
 *  [20,9],
 *  [15,7]
 * ]
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
   * @return: A list of lists of integer include
   *          the zigzag level order traversal of its nodes' values
   */
  public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
    // write your code here
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    Stack<TreeNode> curLevel = new Stack<TreeNode>();
    Stack<TreeNode> nextLevel = new Stack<TreeNode>();
    boolean left = true;
    curLevel.push(root);
    while(!curLevel.empty()) {
      ArrayList<Integer> level = new ArrayList<Integer>();
      int size = curLevel.size();
      for (int i = 0; i < size; i++) {
        TreeNode cur = curLevel.pop();
        level.add(cur.val);
        if (left) {
          saveNode(cur.left, nextLevel);
          saveNode(cur.right, nextLevel);
        } else {
          saveNode(cur.right, nextLevel);
          saveNode(cur.left, nextLevel);
        }
      }
      result.add(level);
      curLevel = nextLevel;
      nextLevel = new Stack<TreeNode>();
      left = !left;
    }
    return result;
  }

  private void saveNode(TreeNode root, Stack<TreeNode> myStack) {
    if (root != null) {
      myStack.push(root);
    }
  }
}