/**
 * Interval Sum II
 * www.lintcode.com/en/problem/interval-sum-ii/
 *
 * Given an integer array in the construct mothod, implement two methods query(start, end) and modify(index, value):
 *   For query(start, end), return the sum form index start to index end in the given array.
 *   For modify(index, value), modify the number in the given index to value.
 *
 * Example
 * Given array A = [1, 2, 7, 8, 5].
 *   query(0, 2), return 10.
 *   modify(0, 4), change A[0] from 1 to 4.
 *   query(0, 1), return 6.
 *   modiry(2, 1), change A[2] from 7 to 1.
 *   query(2, 4), return 14.
 */

public class Solution {
  /* you may need to use some attributes here */
  private SegmentTreeNode seg;
  private int[] nums;
  /**
   * @param A: An integer array
   */
  public Solution(int[] A) {
    // write your code here
    nums = A;
    seg = buildSeg(A, 0, A.length - 1);
  }

  /**
   * @param start, end: Indices
   * @return: The sum from start to end
   */
  public long query(int start, int end) {
    // write your code here
    return query(seg, start, end);
  }

  /**
   * @param index, value: modify A[index] to value.
   */
  public void modify(int index, int value) {
    // write your code here
    if (index >= 0 && index < nums.length) {
      nums[index] = value;
      modify(seg, index, value);
    }
  }

  private class SegmentTreeNode {
    long sum;
    int start, end;
    SegmentTreeNode left, right;

    SegmentTreeNode(int start, int end) {
      sum = 0L;
      this.start = start;
      this.end = end;
      left = right = null;
    }
  }

  private SegmentTreeNode buildSeg(int[] A, int start, int end) {
    if (start > end) {
      return null;
    }
    SegmentTreeNode root = new SegmentTreeNode(start, end);
    if (start == end) {
      root.sum = A[start];
      return root;
    }
    int mid = start + (end - start) / 2;
    root.left = buildSeg(A, start, mid);
    root.right = buildSeg(A, mid + 1, end);
    root.sum = root.left.sum + root.right.sum;

    return root;
  }

  private long query(SegmentTreeNode root, int start, int end) {
    if (start <= root.start && end >= root.end) {
      return root.sum;
    }

    int mid = root.start + (root.end - root.start) / 2;
    long left = 0L, right = 0L;
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

  private void modify (SegmentTreeNode root, int index, int value) {
    if (index < root.start || index > root.end) {
      return;
    }
    if (root.start == root.end && root.start == index) {
      root.sum = value;
      return;
    }

    int mid = root.start + (root.end - root.start) / 2;
    if (index <= mid) {
      modify(root.left, index, value);
    } else {
      modify(root.right, index, value);
    }

    root.sum = root.left.sum + root.right.sum;
  }
}

