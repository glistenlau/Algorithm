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
  public List<Interval> merge(List<Interval> intervals) {
    List<Interval> result = new ArrayList<Interval>();
    if (intervals == null || intervals.size() == 0) {
      return result;
    }

    intervals.sort(intervalComparator);

    Interval pre = intervals.get(0);

    for (Interval iv: intervals) {
      if (iv.start <= pre.end && iv.end > pre.end) {
        pre.end = iv.end;
      } else if (iv.end > pre.end) {
        result.add(pre);
        pre = iv;
      }
    }

    result.add(pre);
    return result;
  }

  private Comparator<Interval> intervalComparator = new Comparator<Interval>() {
    public int compare(Interval i1, Interval i2) {
      if (i1 == null) {
        return -1;
      }
      if (i2 == null) {
        return 1;
      }
      return i1.start - i2.start;
    }
  };

}