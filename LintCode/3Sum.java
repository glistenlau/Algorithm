/**
 * 3 Sum
 * www.lintcode.com/en/problem/3-sum/
 *
 * Given an array S of n integers, are there elements a, b, c in S such that
 * a + b + c = 0 ? Find all unique triplets in the array which gives the sum
 * of zero.
 *
 * Example
 * For example, given array S = {-1 0 1 2 -1 -4}, A solution set is:
 *   (-1, 0, 1)
 *   (-1, -1, 2)
 */

public class Solution {
  /**
   * @param numbers : Give an array numbers of n integer
   * @return : Find all unique triplets in the array which gives the sum of zero.
   */

  // O(n^2) Time, O(1) Space
  public ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
// write your code here
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    if (numbers == null || numbers.length < 3) {
      return result;
    }
    Arrays.sort(numbers);

    for (int i = 0; i < numbers.length; i++) {
      if (i != 0 && numbers[i] == numbers[i - 1]) {
        continue;
      }
      int left = i + 1;
      int right = numbers.length - 1;
      while (left < right) {
        int sum = numbers[i] + numbers[left] + numbers[right];
        if (sum == 0) {
          ArrayList<Integer> temp = new ArrayList<Integer>();
          temp.add(numbers[i]);
          temp.add(numbers[left++]);
          temp.add(numbers[right--]);
          result.add(temp);
          while (left < right && numbers[left] == numbers[left - 1]) {
            left++;
          }
          while (left < right && numbers[right] == numbers[right + 1]) {
            right--;
          }
        } else if (sum < 0) {
          left++;
        } else {
          right--;
        }
      }
    }
    return result;
  }
}

