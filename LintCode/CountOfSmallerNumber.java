// Solution 1: Sort and Binary Search
public class Solution {
  /**
   * @param A: An integer array
   * @return: The number of element in the array that
   *          are smaller that the given integer
   */
  public ArrayList<Integer> countOfSmallerNumber(int[] A, int[] queries) {
    // write your code here

    Arrays.sort(A);

    ArrayList<Integer> result = new ArrayList<Integer>();
    for (int query: queries) {
      result.add(findPos(A, query));
    }

    return result;
  }

  private int findPos(int[] A, int tar) {
    if (A == null || A.length == 0) {
      return 0;
    }
    int left = 0;
    int right = A.length - 1;

    while (left + 1 < right) {
      int mid = left + (right - left) / 2;
      if (A[mid] >= tar) {
        right = mid;
      } else if (A[mid] < tar) {
        left = mid;
      }
    }

    if (A[left] >= tar) {
      return left;
    }
    if (A[right] >= tar) {
      return right;
    } else {
      return right + 1;
    }
  }
}

// Solution 2: Segment Tree
public class Solution {
  /**
   * @param A: An integer array
   * @return: The number of element in the array that
   *          are smaller that the given integer
   */
  public ArrayList<Integer> countOfSmallerNumber(int[] A, int[] queries) {
    // write your code here
    SegmentTreeNode seg = buildSegmentTree(0, 10000);
    ArrayList<Integer> result = new ArrayList<Integer>();
    for (int n: A) {
      addToSegmentTree(seg, n);
    }
    for (int query: queries) {
      result.add(query(seg, 0, query - 1));
    }

    return result;
  }

  private class SegmentTreeNode{
    int count, start, end;
    SegmentTreeNode left, right;

    SegmentTreeNode (int start, int end) {
      this.start = start;
      this.end = end;
      count = 0;
      left = right = null;
    }
  }

  private SegmentTreeNode buildSegmentTree(int start, int end) {
    SegmentTreeNode root = new SegmentTreeNode(start, end);
    if (start == end) {
      return root;
    }

    int mid = start + (end - start) / 2;
    root.left = buildSegmentTree(start, mid);
    root.right = buildSegmentTree(mid + 1, end);
    return root;
  }

  private void addToSegmentTree(SegmentTreeNode root, int tar) {

    if (root.start == root.end && root.start == tar) {
      root.count += 1;
      return;
    }

    int mid = root.start + (root.end - root.start) / 2;
    if (tar <= mid) {
      addToSegmentTree(root.left, tar);
      root.count += 1;
    } else {
      addToSegmentTree(root.right, tar);
      root.count += 1;
    }
  }

  private int query(SegmentTreeNode root, int start, int end) {
    if (start <= root.start && end >= root.end) {
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


