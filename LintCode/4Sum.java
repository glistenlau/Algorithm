/**
 * 4 Sum
 * http://www.lintcode.com/en/problem/4-sum/
 *
 * Given an array S of n integers, are there elements a, b, c and d in S such
 * that a + b + c + d = target? Find all unique quadruplets in the array
 * which gives the sum of target.
 *
 * Example
 * For example, given array S = {1 0 -1 0 -2 2}, and target = 0. A solution
 * set is:
 * (-1, 0, 0, 1)
 * (-2, -1, 1, 2)
 * (-2, 0, 0, 2)
 */

public class Solution {
  /**
   * @param numbers : Give an array numbersbers of n integer
   * @param target : you need to find four elements that's sum of target
   * @return : Find all unique quadruplets in the array which gives the sum of
   *           zero.
   */
  public ArrayList<ArrayList<Integer>> fourSum(int[] numbers, int target) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    if (numbers == null || numbers.length == 0) {
      return result;
    }
    Arrays.sort(numbers);
    for (int i = 0; i < numbers.length; i++) {
      if (i != 0 && numbers[i] == numbers[i - 1]) {
        continue;
      }
      for (int j = i + 1; j < numbers.length; j++) {
        if (j != i + 1 && numbers[j] == numbers[j - 1]) {
          continue;
        }
        int left = j + 1;
        int right = numbers.length - 1;
        while (left < right) {
          int sum = numbers[i] + numbers[j] + numbers[left] + numbers[right];
          if (sum == target) {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            temp.add(numbers[i]);
            temp.add(numbers[j]);
            temp.add(numbers[left]);
            temp.add(numbers[right]);
            result.add(temp);
            left++;
            right--;
          } else if (sum < target) {
            left++;
          } else {
            right--;
          }
          while(left > j + 1 && numbers[left] == numbers[left - 1]) {
            left++;
          }
          while(right < numbers.length - 1 && numbers[right] == numbers[right + 1]) {
            right--;
          }
        }
      }
    }
    return result;
  }
}

