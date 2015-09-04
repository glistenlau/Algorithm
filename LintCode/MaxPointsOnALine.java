/**
 * Max Points on a Line
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 *
 * Example
 * Given 4 points: (1, 2), (3, 6), (0, 0), (1, 3).
 * The maximum number is 3.
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
   * @param points an array of point
   * @return an integer
   */
  public int maxPoints(Point[] points) {
    if (points == null || points.length == 0) {
      return 0;
    }

    int max = 1;
    for (int i = 0; i < points.length; i++) {
      HashMap<Double, Integer> map = new HashMap<>();
      int same = 1;
      for (int j = i + 1; j < points.length; j++) {
        if (points[i].x == points[j].x && points[i].y == points[j].y) {
          same++;
        } else {
          double slope = getSlope(points[i], points[j]);
          if (!map.containsKey(slope)) {
            map.put(slope, 0);
          }
          map.put(slope, map.get(slope) + 1);
        }
      }
      if (map.isEmpty()) {
        max = Math.max(same, max);
      } else {
        for (int count: map.values()) {
          max = Math.max(max, count + same);
        }
      }
    }

    return max;
  }

  private double getSlope(Point a, Point b) {
    int dx = a.x - b.x;
    int dy = a.y - b.y;
    if (dx == 0) {
      return (double)Integer.MAX_VALUE;
    }
    if (dy == 0) {
      return 0.0;
    }
    return (double)dy/dx;
  }
}
