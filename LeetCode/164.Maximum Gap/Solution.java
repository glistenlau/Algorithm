public class Solution {
  private class Interval{
    int start, end;
    Interval(int start, int end) {
      this.start = start;
      this.end = end;
    }
  }

  public int maximumGap(int[] nums) {
    if (nums == null || nums.length < 2) {
      return 0;
    }

    HashSet<Integer> numbers = new HashSet<Integer>();

    int min = nums[0];
    int max = nums[0];

    for (int num: nums) {
      numbers.add(num);
      min = Math.min(min, num);
      max = Math.max(max, num);
    }

    int bucketLen = (max - min - 1) / nums.length + 1;
    Interval[] intervals = new Interval[(max - min) / bucketLen + 1];

    for (int num: nums) {
      int bucketIndex = (num - min) / bucketLen;
      if (intervals[bucketIndex] == null) {
        intervals[bucketIndex] = new Interval(num, num);
      } else {
        intervals[bucketIndex].start = Math.min(intervals[bucketIndex].start, num);
        intervals[bucketIndex].end = Math.max(intervals[bucketIndex].end, num);
      }
    }


    Interval pre = null;
    int maxGap = 0;
    for (Interval in: intervals) {
      if (in == null) {
        continue;
      }
      if (pre != null) {
        maxGap = Math.max(maxGap, in.start - pre.end);
      }
      pre = in;
    }

    return maxGap;
  }
}