/**
 * Kth Smallest Number in Sorted Matrix
 * Find the kth smallest number in at row and column sorted matrix.
 *
 * Example
 * Given k = 4 and matrix:
 * [
 *   [1, 5, 7],
 *   [3, 7, 8],
 *   [4, 8, 9],
 * ]
 *
 * return 5.
 */
public class Solution {
  /**
   * @param matrix: a matrix of integers
   * @param k: an integer
   * @return: the kth smallest number in the matrix
   */

  private class Node{
    int val;
    int x, y;

    Node (int val, int x, int y) {
      this.val = val;
      this.x = x;
      this.y = y;
    }
  }

  public int kthSmallest(int[][] matrix, int k) {
    // write your code here
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return -1;
    }
    int m = matrix.length;
    int n = matrix[0].length;

    PriorityQueue<Node> myQ = new PriorityQueue<>(m * n, matrixCmp);
    int[] dx = {1, 0};
    int[] dy = {0, 1};
    boolean[][] added = new boolean[m][n];
    int count = 0;

    myQ.offer(new Node(matrix[0][0], 0, 0));
    added[0][0] = true;

    while (!myQ.isEmpty()) {
      Node cur = myQ.poll();
      count++;
      if (count == k) {
        return cur.val;
      }

      for (int i = 0; i < 2; i++) {
        int r = cur.x + dx[i];
        int c = cur.y + dy[i];
        if (r >= 0 && r < m && c >= 0 && c < n && !added[r][c]) {
          myQ.offer(new Node(matrix[r][c], r, c));
          added[r][c] = true;
        }
      }
    }

    return -1;
  }

  private Comparator<Node> matrixCmp = new Comparator<Node>() {
    @Override
    public int compare(Node a, Node b) {
      return a.val - b.val;
    }
  };
}
