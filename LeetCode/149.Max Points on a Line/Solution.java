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
  public int maxPoints(Point[] points) {
    if (points == null || points.length == 0) {
      return 0;
    }

    HashMap<Integer, HashSet<Double>> slopes = new HashMap<>();
    for (int i = 0; i < points.length; i++) {
      slopes.put(i, new HashSet<>());
    }

    int max = 1;
    for (int i = 0; i < points.length; i++) {
      HashMap<Double, Integer> count = new HashMap<>();
      int ori = 1;
      for (int j = i + 1; j < points.length; j++) {
        double sl = points[i].x == points[j].x? Integer.MAX_VALUE: (double)(points[j].y - points[i].y) / (points[j].x - points[i].x);

        if (sl == -0) {
          sl = 0;
        }

        if (slopes.get(j).contains(sl)) {
          continue;
        }

        if (!count.containsKey(sl)) {
          count.put(sl, ori);
        }

        if (points[i].x == points[j].x && points[i].y == points[j].y) {
          for(double slope: count.keySet()) {
            count.put(slope, count.get(slope) + 1);
            max = Math.max(max, count.get(slope));
          }
          ori++;
        } else {
          count.put(sl, count.get(sl) + 1);
          max = Math.max(max, count.get(sl));
        }

        slopes.get(j).add(sl);
      }
    }

    return max;
  }
}