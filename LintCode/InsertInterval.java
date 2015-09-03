/**
 * Insert Interval
 * www.lintcode.com/en/problem/insert-interval/
 *
 * Given a non-overlapping list which is sorted by start point.
 *
 * Insert a new interval into it, make sure the list is still in order and non-overlapping.
 *
 * Example
 * Insert [2, 5] into [[1, 2], [5, 9]], we get[[1, 9]].
 * Insert [3, 4] into [[1, 2], [5, 9]], we get[[1, 2], [3, 4], [5, 9]].
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

class Solution {
  /**
   * Insert newInterval into intervals.
   * @param intervals: Sorted interval list.
   * @param newInterval: A new interval.
   * @return: A new sorted interval list.
   */
  public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
    ArrayList<Interval> result = new ArrayList<Interval>();
    // write your code here
    if (intervals == null || intervals.size() == 0) {
      result.add(newInterval);
      return result;
    }
    if (newInterval == null) {
      return intervals;
    }
    int i = 0;
    while (i < intervals.size()) {
      if (intervals.get(i).end < newInterval.start) {
        i++;
      } else if (intervals.get(i).start > newInterval.end) {
        break;
      } else {

        newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
        newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
        intervals.remove(i);

      }
    }
    intervals.add(i, newInterval);
    return intervals;
  }
}
