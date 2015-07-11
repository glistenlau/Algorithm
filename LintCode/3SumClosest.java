/**
 * 3 Sum Closest
 * www.lintcode.com/en/problem/3-sum-closest/
 *
 * Given an array S of n integers, find three integers in S such that the sum
 * is closest to a given number, target.
 * Return the sum of the three integers.
 *
 * Example
 * For example, given array S = {-1 2 1 -4}, and target = 1. The sum that is
 * closest to the target is 2.
 */

public class Solution {
  /**
   * @param numbers: Give an array numbers of n integer
   * @param target : An integer
   * @return : return the sum of the three integers, the sum closest target.
   */

  // O(n^2) Time, O(1) extra Space
  public int threeSumClosest(int[] numbers, int target) {
    if (numbers == null || numbers.length < 3) {
      return 0;
    }
    Arrays.sort(numbers);
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < numbers.length; i++) {
      if (i != 0 && numbers[i] == numbers[i - 1]) {
        continue;
      }
      int left = i + 1;
      int right = numbers.length - 1;
      while (left < right) {
        int sum = numbers[i] + numbers[left] + numbers[right];
        min = Math.abs(sum - target) < Math.abs(min - target) ? sum : min;
        if (sum == target) {
          return target;
        } else if (sum < target) {
          left++;
          while (left < right && numbers[left] == numbers[left - 1]) {
            left++;
          }
        } else {
          right--;
          while (left < right && numbers[right] == numbers[right + 1]) {
            right--;
          }
        }
      }
    }
    return min;
  }
}


