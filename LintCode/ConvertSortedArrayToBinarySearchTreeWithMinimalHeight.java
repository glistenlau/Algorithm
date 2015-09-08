/**
 * Convert Sorted Array to Binary Search Tree With Minimal Height
 * www.lintcode.com/en/problem/convert-sorted-array-to-binary-search-tree-with-minimal-height/
 *
 * Given a sorted(increasing order) array, Convert it to create a binary tree with minimal height.
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
   * @param A: an integer array
   * @return: a tree node
   */
  public TreeNode sortedArrayToBST(int[] A) {
    // write your code here
    if (A == null || A.length == 0) {
      return null;
    }

    return sortedArrayToBST(A, 0, A.length - 1);
  }

  private TreeNode sortedArrayToBST(int[] A, int left, int right) {
    if (left > right) {
      return null;
    }

    int mid = left + (right - left) / 2;
    TreeNode root = new TreeNode(A[mid]);
    root.left = sortedArrayToBST(A, left, mid - 1);
    root.right = sortedArrayToBST(A, mid + 1, right);

    return root;
  }
}

