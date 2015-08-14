/**
 * Segment Tree Query II
 * http://www.lintcode.com/en/problem/segment-tree-query-ii/
 *
 * For an array, we can build a SegmentTree for it, each node stores an extra attribute
 * count to denote the number of elements in the the array which value is between interval
 * start and end. (The array may not fully filled by elements)
 *
 * Design a query method with three parameters root, start and end, find the number
 * of elements in the in array's interval [start, end] by the given root of value SegmentTree.
 */

/**
 * Definition of SegmentTreeNode:
 * public class SegmentTreeNode {
 *     public int start, end, count;
 *     public SegmentTreeNode left, right;
 *     public SegmentTreeNode(int start, int end, int count) {
 *         this.start = start;
 *         this.end = end;
 *         this.count = count;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
  /**
   *@param root, start, end: The root of segment tree and
   *                         an segment / interval
   *@return: The count number in the interval [start, end]
   */
  public int query(SegmentTreeNode root, int start, int end) {
    // write your code here
    if (root == null) {
      return 0;
    }

    if (root.start >= start && root.end <= end) {
      return root.count;
    }

    int mid = root.start + (root.end - root.start) / 2;
    int left = 0;
    int right = 0;
    if (start <= mid) {
      if (end > mid) {
        left = query(root.left, start, mid);
      } else {
        left = query(root.left, start, end);
      }
    }
    if (end > mid) {
      if (start <= mid) {
        right = query(root.right, mid + 1, end);
      } else {
        right = query(root.right, start, end);
      }
    }

    return left + right;
  }
}
