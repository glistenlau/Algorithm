/**
 * Majority Number III
 * www.lintcode.com/en/problem/majority-number-iii/
 *
 * Given an array of integers and a number k, the majority number is the
 * number that occurs more than 1 / k of the size of the array. Find it
 *
 * Example
 * Given [3, 1, 2, 3, 2, 3, 3, 4, 4, 4] and k = 3, return 3.
 */

public class Solution {
  /**
   * @param nums: A list of integers
   * @param k: As described
   * @return: The majority number
   */
  public int majorityNumber(ArrayList<Integer> nums, int k) {
    if (nums == null || nums.size() == 0) {
      return -1;
    }

    ArrayList<Integer> candidates = new ArrayList<Integer>();
    ArrayList<Integer> counts = new ArrayList<Integer>();

    for (int i = 0; i < nums.size(); i++) {
      int n = nums.get(i);
      if (candidates.contains(n)) {
        counts.set(candidates.indexOf(n), counts.get(candidates.indexOf(n)) + 1);
      } else {
        if (candidates.size() == k - 1) {
          int j = 0;
          while (j < candidates.size()) {
            if (counts.get(j) == 1) {
              candidates.remove(j);
              counts.remove(j);
            } else {
              counts.set(j, counts.get(j) - 1);
              j++;
            }
          }
        } else {
          candidates.add(n);
          counts.add(1);
        }
      }
    }

    Collections.fill(counts, 0);
    for (int n : nums) {
      if (candidates.contains(n)) {
        counts.set(candidates.indexOf(n), counts.get(candidates.indexOf(n)) + 1);
      }
    }
    int max = 0;
    int index = 0;
    for (int i = 0; i < counts.size(); i++) {
      if (counts.get(i) > max) {
        max = counts.get(i);
        index = i;
      }
    }
    return candidates.get(index);
  }
}