/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
  public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    List<Interval> result = new ArrayList<Interval>();
    if (intervals == null || intervals.size() == 0) {
      result.add(newInterval);
      return result;
    }

    boolean inserted = false;
    for (Interval iv: intervals) {
      if (!inserted) {
        if ( iv.end < newInterval.start) {
          result.add(iv);
        } else if (newInterval.end < iv.start) {
          result.add(newInterval);
          result.add(iv);
          inserted = true;
        } else {
          newInterval.start = Math.min(newInterval.start, iv.start);
          newInterval.end = Math.max(newInterval.end, iv.end);
        }
      }
      else {
        result.add(iv);
      }
    }

    if (!inserted) {
      result.add(newInterval);
    }

    return result;
  }
}