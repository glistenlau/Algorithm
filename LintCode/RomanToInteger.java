/**
 * Roman to Integer
 * www.lintcode.com/en/problem/roman-to-integer/
 *
 * Given a roman numeral, convert it to an integer.
 * The answer is guaranteed to be within the range from 1 to 3999.
 *
 * Example
 * IV -> 4
 * XII -> 12
 * XXI -> 21
 * XCIX -> 99
 */
public class Solution {
  /**
   * @param s Roman representation
   * @return an integer
   */
  public int romanToInt(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }

    int[] nums = {1, 5, 10, 50, 100, 500, 1000};
    char[] romans = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};

    int[] map = new int[26];
    for (int i = 0; i < nums.length; i++) {
      map[romans[i] - 'A'] = nums[i];
    }

    int ans = 0;
    for (int i = 0; i < s.length(); i++) {
      if (i < s.length() - 1 && map[s.charAt(i) - 'A'] < map[s.charAt(i + 1) - 'A']) {
        ans += map[s.charAt(i + 1) - 'A'] - map[s.charAt(i) - 'A'];
        i++;
      } else {
        ans += map[s.charAt(i) - 'A'];
      }
    }

    return ans;
  }
}
