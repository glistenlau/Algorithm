/**
 * Two Strings Are Anagrams
 * http://www.lintcode.com/en/problem/two-strings-are-anagrams/
 *
 * Write a method anagram(s,t) to decide if two strings are anagrams or not.
 *
 * Example
 * Given s="abcd", t="dcab", return true.
 */

public class Solution {
  /**
   * @param s: The first string
   * @param b: The second string
   * @return true or false
   */
  public boolean anagram(String s, String t) {
    // write your code here
    int[] lookup = new int[256];
    for (int i = 0; i < s.length(); i++) {
      lookup[s.charAt(i)] += 1;
    }
    for (int j = 0; j < t.length(); j++) {
      lookup[t.charAt(j)] -= 1;
      if (lookup[t.charAt(j)] < 0) {
        return false;
      }
    }
    return true;
  }
}