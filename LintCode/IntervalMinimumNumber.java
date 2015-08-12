/**
 * Interval Minimum Number
 * http://www.lintcode.com/en/problem/interval-minimum-number/
 *
 * Given an integer array(index form 0 to n - 1, where n is the size of this array), and an query list.
 * Each query has two integers [start, end]. For each query, calculate the minimum number between index
 * start and end in the given array, return the result list.
 *
 * Example
 * For array [1, 2, 7, 8, 5], and queries [(1, 2), (0, 4), (2, 4)], return [2, 1, 5].
 */

/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */
public class Solution {
  /**
   *@param A, queries: Given an integer array and an query list
   *@return: The result list
   */
  public ArrayList<Integer> intervalMinNumber(int[] A,
                                              ArrayList<Interval> queries) {
    // write your code here
    ArrayList<Integer> result = new ArrayList<Integer>();
    if (A == null || A.length == 0) {
      return result;
    }
    SegmentTreeNode minSegTree = build(A, 0, A.length - 1);
    for (Interval in: queries) {
      result.add(query(minSegTree, in.start, in.end));
    }

    return result;
  }

  private SegmentTreeNode build (int[] A, int start, int end) {
    SegmentTreeNode root = new SegmentTreeNode(start, end);
    if (start == end) {
      root.min = A[start];
      return root;
    }
    int mid = start + (end - start) / 2;
    root.left = build(A, start, mid);
    root.right = build(A, mid + 1, end);
    root.min = Math.min(root.left.min, root.right.min);
    return root;
  }

  private int query(SegmentTreeNode root, int start, int end) {
    if (root.start == start && root.end == end) {
      return root.min;
    }
    int left = Integer.MAX_VALUE;
    int right = Integer.MAX_VALUE;
    int mid = root.start + (root.end - root.start) / 2;
    if (start <= mid) {
      if (end > mid) {
        left = query(root.left, start, mid);
      } else {
        left = query(root.left, start, end);
      }
    }
    if (mid < end) {
      if (start <= mid) {
        right = query(root.right, mid + 1, end);
      } else {
        right = query(root.right, start, end);
      }
    }
    return Math.min(left, right);
  }

  private class SegmentTreeNode {
    int start;
    int end;
    int min;
    SegmentTreeNode left, right;
    public SegmentTreeNode(int start, int end) {
      this.start = start;
      this.end = end;
      this.min = Integer.MAX_VALUE;
      this.left = null;
      this.right = null;
    }
  }
}
