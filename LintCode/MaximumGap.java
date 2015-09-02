/**
 * Maximum Gap
 * www.lintcode.com/en/problem/maximum-gap/
 *
 * Given an unsorted array, find the maximum difference between the successive elements
 * in its sorted form.
 *
 * Return 0 if the array contains less than 2 elements.
 *
 * Example
 * Given[1, 9, 2, 5], the sorted form of it is [1, 2, 5, 9], the maximum gap is between
 * 5 and 9 = 4.
 */
class Solution {
  /**
   * @param nums: an array of integers
   * @return: the maximum difference
   */
  private class Bucket {
    int max, min;
    Bucket() {
      this.max = Integer.MIN_VALUE;
      this.min = Integer.MAX_VALUE;
    }
  }

  public int maximumGap(int[] nums) {
    // write your code here
    if (nums == null || nums.length < 2) {
      return 0;
    }

    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    for (int num: nums) {
      max = Math.max(max, num);
      min = Math.min(min, num);
    }

    int len = (max - min) / nums.length + 1;
    Bucket[] b = new Bucket[(max - min) / len + 1];

    for (int num: nums) {
      int id = (num - min) / len;
      if (b[id] == null) {
        b[id] = new Bucket();
      }
      b[id].min = Math.min(b[id].min, num);
      b[id].max = Math.max(b[id].max, num);
    }

    int ans = 0;
    Bucket pre = b[0];
    for (Bucket bucket:b) {
      if (bucket == null) {
        continue;
      }
      ans = Math.max(ans, bucket.min - pre.max);
      pre = bucket;
    }

    return ans;

  }
}
