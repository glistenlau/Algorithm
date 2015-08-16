/**Count of Smaller Number before itself
 * www.lintcode.com/en/problem/count-of-smaller-number-before-itself/
 *
 * Given you an integer array(index from 0 to n - 1, where n is the size of this array., value from 0 to 10000).
 * For each element Ai in the array, count the number of element before this element Ai is smaller than it and
 * return count number array.
 *
 * Example
 * For array[1, 2, 7, 8, 5], return [0, 1, 2, 3, 2].
 */

public class Solution {
  /**
   * @param A: An integer array
   * @return: Count the number of element before this element 'ai' is
   *          smaller than it and return count number array
   */
  public ArrayList<Integer> countOfSmallerNumberII(int[] A) {
    // write your code here
    ArrayList<Integer> result = new ArrayList<>();
    if (A == null || A.length == 0) {
      return result;
    }

    SegmentTreeNode root = buildTree(0, 10000);
    for (int num: A) {
      result.add(query(root, 0, num - 1));
      addToTree(root, num);
    }

    return result;
  }

  private class SegmentTreeNode {
    int start, end, count;
    SegmentTreeNode left, right;
    SegmentTreeNode(int start, int end) {
      count = 0;
      this.start = start;
      this.end = end;
      left = right = null;
    }
  }

  private SegmentTreeNode buildTree(int start, int end) {
    SegmentTreeNode root = new SegmentTreeNode(start, end);
    if (start == end) {
      return root;
    }

    int mid = start + (end - start) / 2;
    root.left = buildTree(start, mid);
    root.right = buildTree(mid + 1, end);
    return root;
  }

  private int query(SegmentTreeNode root, int start, int end) {
    if (start > end) {
      return 0;
    }
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

  private void addToTree(SegmentTreeNode root, int num) {
    if (num < root.start || num > root.end) {
      return;
    }
    if (root.start == root.end && root.start == num) {
      root.count += 1;
      return;
    }

    int mid = root.start + (root.end - root.start) / 2;
    if (num <= mid) {
      addToTree(root.left, num);
    } else {
      addToTree(root.right, num);
    }
    root.count = root.left.count + root.right.count;
  }
}