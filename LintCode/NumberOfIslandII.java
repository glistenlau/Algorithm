/**
 * Number of Islands II
 * www.lintcode.com/en/problem/number-of-islands-ii/
 *
 * Given a n, m which means row and column of the 2D matrix and an array of pair A(size k). Originally, the 2D matrix is all 0
 * which means there is only sea in the matrix. The list pair has k operators and each operator has two integer A[i].x, A[i].y
 * means that you can change the grid matrix[A[i].x, A[i].y] from sea to island. Return how many island are there in the matrix
 * after each operator.
 *
 * Example
 * Given n = 3, m = 3, array of pair A = [(0, 0), (0, 1), (2, 2), (2, 1)].
 * return [1, 1, 2, 2];
 */

/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
  /**
   * @param n an integer
   * @param m an integer
   * @param operators an array of point
   * @return an integer array
   */
  public List<Integer> numIslands2(int n, int m, Point[] operators) {
    // Write your code here
    List<Integer> result = new ArrayList<Integer>();
    if (operators == null || operators.length == 0) {
      return result;
    }
    UnionFind uf = new UnionFind(n, m);
    int[][] matrix = new int[n][m];
    int[] rowOffset = {-1, 1, 0, 0};
    int[] colOffset = {0, 0, -1, 1};
    int count = 0;

    for (Point p: operators) {
      matrix[p.x][p.y] = 1;
      for (int i = 0; i < 4; i++) {
        int row = p.x + rowOffset[i];
        int col = p.y + colOffset[i];
        if (row >= 0 && row < n && col >= 0 && col < m && matrix[row][col] == 1) {
          if (uf.compressedFind(p.x * m + p.y) != uf.compressedFind(row * m + col)) {
            uf.union(p.x * m + p.y, row * m + col);
            count--;
          }
        }
      }
      result.add(++count);
    }

    return result;
  }

  private class UnionFind {
    int[] fathers;

    UnionFind(int row, int col) {
      fathers = new int[row * col];
      for (int i = 0; i < fathers.length; i++) {
        fathers[i] = i;
      }
    }

    int compressedFind(int pos) {
      int father = fathers[pos];
      while (father != fathers[father]) {
        father = fathers[father];
      }

      int fa = fathers[pos];
      while (fa != fathers[fa]) {
        int temp = fathers[fa];
        fathers[fa] = father;
        fa = temp;
      }

      return father;
    }

    void union(int a, int b) {
      int aFa = compressedFind(a);
      int bFa = compressedFind(b);
      if (aFa != bFa) {
        fathers[bFa] = aFa;
      }
    }
  }
}
