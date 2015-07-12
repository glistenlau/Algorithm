/**
 * Given an unsorted array of integers, find the length of the longest
 * consecutive elements sequence.
 *
 * Example [100, 4, 200, 1, 3, 2], the longest consecutive element sequence
 * is [1, 2, 3, 4], Return its length: 4.
 */

public class Solution {
  /**
   * @param nums: A list of integers
   * @return an integer
   */
  public int longestConsecutive(int[] num) {
    if (num == null || num.length == 0){
      return -1;
    }
    HashSet<Integer> lookup = new HashSet<Integer>();
    for (int n: num) {
      lookup.add(n);
    }
    int max = 0;
    for (int n: num) {
      if (!lookup.contains(n - 1)) {
        int m = n + 1;
        while(lookup.contains(m)) {
          m++;
        }
        max = Math.max(max, m - n);
      }
    }
    return max;
  }
}
