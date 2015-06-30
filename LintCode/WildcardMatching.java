/**
 * Wildcard Matching
 * http://www.lintcode.com/en/problem/wildcard-matching/
 *
 * Implement wildcard pattern matching with support for '?' and '*'.
 *   '?' Matches any single character/
 *   '*' Matches any sequence of characters (including the empty sequence).
 *
 * The matching should cover the entire input string (not partial).
 *
 * Example
 * isMatch("aa", "a") -> false
 * isMatch("aa", "aa") -> true
 * isMatch("aaa", "aa") -> false
 * isMatch("aa", "*") -> true
 * isMatch("aa", "a*") -> true
 * isMatch("ab", "?*") -> true
 * isMatch("aab", "c*a*b) -> false
 */
public class Solution {
  /**
   * @param s: A string
   * @param p: A string includes "?" and "*"
   * @return: A boolean
   */

  //iterative
  public boolean isMatch(String s, String p) {
    // write your code here
    if (s == null || p == null) {
      return true;
    }
    int i = 0;
    int j = 0;
    int preStar = -1;
    int preS = -1;
    while (i < s.length() && j < p.length()) {
      if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
        i++;
        j++;
        continue;
      }
      if (p.charAt(j) == '*') {
        while (j < p.length() && p.charAt(j) == '*') {
          j++;
        }
        if (j == p.length()) {
          return true;
        }
        preStar = j - 1;
        preS = i;
      } else {
        if (preStar >= 0) {
          j = preStar;
          i = preS + 1;
          preStar = -1;
        } else {
          return false;
        }
      }
    }
    while(j < p.length() && p.charAt(j) == '*') {
      j++;
    }
    return i == s.length() && j == p.length();
  }
}
