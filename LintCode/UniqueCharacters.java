/**
 * Unique Characters
 * www.lintcode.com/en/problem/unique-characters/
 *
 * Implement an algorithm to determine if a string has all unique characters.
 */
public class Solution {
  /**
   * @param str: a string
   * @return: a boolean
   */
  public boolean isUnique(String str) {
    // write your code here
    int[] map =  new int[8];

    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);
      int n = c / 32;
      int s = c % 32;
      if (((map[n] >>> s) & 1) == 1) {
        return false;
      }
      map[n] |= (1 << s);
    }

    return true;
  }
}
