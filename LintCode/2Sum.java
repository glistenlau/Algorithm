/**
 * 2 Sum
 * www.lintcode.com/en/problem/2-sum/#
 *
 * Given an array of Integers, find twoo numbers such that they add up to a
 * specific target number.
 *
 * The function twoSum should return indices of the two numbers such that
 * they add up to the target, where index1 must be less than index2. Please
 * note that your returned answers (both index1 and index2) are not zero-based.
 */

public class Solution {
  /*
   * @param numbers : An array of Integer
   * @param target : target = numbers[index1] + numbers[index2]
   * @return : [index1 + 1, index2 + 1] (index1 < index2)
   */
  // O(n) Time, O(n) Space
  public int[] twoSum(int[] numbers, int target) {
    if (numbers == null || numbers.length == 0) {
      return null;
    }
    int[] result = new int[2];
    HashMap<Integer, Integer> lookup = new HashMap<Integer, Integer>();
    for (int i = 0; i < numbers.length; i++) {
      int temp = target - numbers[i];
      if (lookup.containsKey(temp)) {
        result[0] = lookup.get(temp) + 1;
        result[1] = i + 1;
        return result;
      } else {
        lookup.put(numbers[i], i);
      }
    }
    return result;
  }
}
