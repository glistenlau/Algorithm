/**
 * Interval Sum
 * http://www.lintcode.com/en/problem/interval-sum/
 *
 * Given an integer array(index from 0 to n - 1, where n is the size of this array), and an query list.
 * Each query has two integers [start, end]. For each query, calculate the sum number between index start
 * and end in the given array, return the result list.
 *
 * Example
 * For array[1, 2, 7, 8, 5], and queries[(0, 4), (1, 2), (2, 4)], return [23, 9, 20].
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
  public ArrayList<Long> intervalSum(int[] A,
                                     ArrayList<Interval> queries) {
    // write your code here
    ArrayList<Long> result = new ArrayList<>();
    SegmentTreeNode seg = buildSegmentTree(A, 0, A.length - 1);
    for (Interval in: queries) {
      result.add(query(seg, in.start, in.end));
    }

    return result;
  }

  private class SegmentTreeNode {
    int start, end;
    long sum;
    SegmentTreeNode left, right;
    SegmentTreeNode(int start, int end) {
      this.start = start;
      this.end = end;
      sum = 0L;
      left = right = null;
    }
  }

  private SegmentTreeNode buildSegmentTree(int[] A, int start, int end) {
    SegmentTreeNode root = new SegmentTreeNode(start, end);
    if (start == end) {
      root.sum = A[start];
      return root;
    }

    int mid = start + (end - start) / 2;
    root.left = buildSegmentTree(A, start, mid);
    root.right = buildSegmentTree(A, mid + 1, end);
    root.sum = root.left.sum + root.right.sum;

    return root;
  }

  private long query(SegmentTreeNode root, int start, int end) {
    if (root.start == start && root.end == end) {
      return root.sum;
    }

    int mid = root.start + (root.end - root.start) / 2;
    long left = 0L;
    long right = 0L;

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

