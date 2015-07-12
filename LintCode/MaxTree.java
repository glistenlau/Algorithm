/**
 * Given an integer array with no duplicates. A max tree building on this
 * array is defined as follow:
 *   The root is the maximum number in the array.
 *   The left subtree and right subtree are the max trees of the sub array
 * divided by the root number.
 *
 * Construct the max tree by the given array.
 *
 * Example
 * Given [2, 5, 6, 0, 3, 1], the max tree constructed by this array is:
 *             6
 *           /  \
 *          5    3
 *        /    /  \
 *       2    0    1
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
   * @param A: Given an integer array with no duplicates.
   * @return: The root of max tree.
   */
  public TreeNode maxTree(int[] A) {
    if (A == null || A.length == 0) {
      return null;
    }

    Stack<TreeNode> maxStack = new Stack<TreeNode>();

    for (int n : A) {
      TreeNode temp = new TreeNode(n);
      while(!maxStack.isEmpty() && n > maxStack.peek().val) {
        temp.left = maxStack.pop();
      }
      if (!maxStack.isEmpty()) {
        maxStack.peek().right = temp;
      }
      maxStack.push(temp);
    }
    TreeNode root = null;
    while(!maxStack.isEmpty()) {
      root = maxStack.pop();
    }
    return root;
  }
}
