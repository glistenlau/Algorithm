/**
 * Segment Tree Build II
 * www.lintcode.com/en/problem/segment-tree-build-ii/
 *
 * The structure of Segment Tree is a binary tree which each node has two attributes start and end denote an segment / interval.
 * start and end are both integers, they should be assigned in following rules:
 *   The root's start and end is given by build method.
 *   The left child of node A has
 *     start = A.left, end = (A.left + A.right) / 2.
 *   The right child of node A has
 *     start = (A.left + A.right) / 2 + 1, end = A.right.
 * Implement a build method with a given array, so that we can create a corresponding segment tree with every node value represent
 * the corresponding interval max value in the array, return the root of this segment tree.
 */
/**
 * Definition of SegmentTreeNode:
 * public class SegmentTreeNode {
 *     public int start, end, max;
 *     public SegmentTreeNode left, right;
 *     public SegmentTreeNode(int start, int end, int max) {
 *         this.start = start;
 *         this.end = end;
 *         this.max = max
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
  /**
   *@param A: a list of integer
   *@return: The root of Segment Tree
   */
  public SegmentTreeNode build(int[] A) {
    // write your code here
    if (A == null || A.length == 0) {
      return null;
    }

    return build(A, 0, A.length - 1);
  }

  private SegmentTreeNode build(int[] A, int left, int right) {
    if (left > right) {
      return null;
    }
    if (left == right) {
      return new SegmentTreeNode(left, right, A[left]);
    }
    int mid = left + (right - left) / 2;
    SegmentTreeNode leftNode = build(A, left, mid);
    SegmentTreeNode rightNode = build(A, mid + 1, right);

    SegmentTreeNode root = new SegmentTreeNode(left, right, Math.max(leftNode.max, rightNode.max));
    root.left = leftNode;
    root.right = rightNode;

    return root;
  }
}
