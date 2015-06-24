/**
 * Search Range in Binary Search Tree
 * http://www.lintcode.com/en/problem/search-range-in-binary-search-tree/
 *
 * Given two values k1 and k2 (where k1 < k2) and a root pointer to a Binary
 * Search Tree. Find all the keys of tree in range k1 to k2. i.e. print all x
 * such that k1<=x<=k2 and x is a key of given BST. Return all the keys in
 * ascending order.
 *
 * Example
 * If k1 = 10 and k2 = 22, then your function should return [12, 20, 22].
 *     20
 *    /  \
 *   8   22
 *  / \
 * 4   12
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
   * @param k1 and k2: range k1 to k2.
   * @return: Return all keys that k1<=key<=k2 in ascending order.
   */
  public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
    // write your code here
    ArrayList<Integer> result = new ArrayList<Integer>();
    search(root, k1, k2, result);
    return result;
  }

  private void search(TreeNode root, int k1, int k2, ArrayList<Integer> result) {
    if (root == null) {
      return;
    }
    if (root.val > k1) {
      search(root.left, k1, k2, result);
    }
    if (root.val >= k1 && root.val <= k2) {
      result.add(root.val);
    }
    if (root.val < k2) {
      search(root.right, k1, k2, result);
    }
  }
}
