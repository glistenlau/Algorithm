/**
 * Trapping Rain Water II
 * www.lintcode.com/en/problem/trapping-rain-water-ii/
 *
 * Given n * m non-negative integers representing an elevation map 2d where the area of each cell is 1 * 1, compute how much water it is able to trap after raining.
 *
 * Example
 * Given 5 * 4 matrix
 * [12, 13, 0, 12]
 * [13, 4, 13, 12]
 * [13, 8, 10, 12]
 * [12, 13, 12, 12]
 * [13, 13, 13, 13]
 *
 * return 14.
 */
public class Solution {
  /**
   * @param heights: a matrix of integers
   * @return: an integer
   */
  public int trapRainWater(int[][] heights) {
    // write your code here
    int result = 0;
    int m = heights.length;
    int n = heights[0].length;
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    boolean[][] visited = new boolean[m][n];
    PriorityQueue<Point> bound = new PriorityQueue<>(2*(m + n), ptCmp);

    for (int i = 0; i < m; i++) {
      bound.offer(new Point(i, 0, heights[i][0]));
      visited[i][0] = true;
      bound.offer(new Point(i, n - 1, heights[i][n - 1]));
      visited[i][n - 1] = true;
    }

    for (int j = 0; j < n; j++) {
      bound.offer(new Point(0, j, heights[0][j]));
      visited[0][j] = true;
      bound.offer(new Point(m - 1, j, heights[m - 1][j]));
      visited[m - 1][j] = true;
    }

    while (!bound.isEmpty()) {
      Point min = bound.poll();

      for (int i = 0; i < 4; i++) {
        int x = min.x + dx[i];
        int y = min.y + dy[i];
        if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y]) {
          continue;
        }
        if (heights[x][y] < min.val) {
          result += min.val - heights[x][y];
          bound.offer(new Point(x, y, min.val));
        } else {
          bound.offer(new Point(x, y, heights[x][y]));
        }
        visited[x][y] = true;
      }

    }

    return result;
  }

  private class Point {
    int x, y, val;
    Point(int x, int y, int val) {
      this.x = x;
      this.y = y;
      this.val = val;
    }
  }

  private Comparator<Point> ptCmp = new Comparator<Point>() {
    @Override
    public int compare(Point a, Point b) {
      return a.val - b.val;
    }
  };
};
