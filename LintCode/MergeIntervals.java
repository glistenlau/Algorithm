/**
 * Merge Intervals
 * www.lintcode.com/en/problem/merge-intervals
 *
 * Given a collection of intervals, merge all overlapping intervals.
 */
/**
 * Definition of Interval:
 * public class Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */

class Solution {
  /**
   * @param intervals: Sorted interval list.
   * @return: A new sorted interval list.
   */
  public List<Interval> merge(List<Interval> intervals) {
    // write your code here
    if (intervals == null || intervals.size() == 0) {
      return new ArrayList<>();
    }
    Collections.sort(intervals, intervalCmp);
    for (int i = 0; i < intervals.size() - 1; i++) {
      if (intervals.get(i).end >= intervals.get(i + 1).start) {
        intervals.get(i).end = Math.max(intervals.get(i).end, intervals.get(i + 1).end);
        intervals.remove(i + 1);
        i--;
      }
    }

    return intervals;
  }

  private Comparator<Interval> intervalCmp = new Comparator<Interval>() {
    @Override
    public int compare (Interval o1, Interval o2) {
      return o1.start - o2.start;
    }
  };
}
