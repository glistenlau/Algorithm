/**
 * Longest PalindromeicSubstring
 * www.lintcode.com/en/problem/longest-palindromic-substring/
 *
 * Given a string s, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000,
 * and there exists one unique longest palindromic substring.
 *
 * Example
 * Given the string = "abcdzdcab", return "cdzdc".
 */

//Solution 1: O(n^2) Time Complexity
public class Solution {
  /**
   * @param s input string
   * @return the longest palindromic substring
   */
  public String longestPalindrome(String s) {
    if (s == null || s.length() == 0) {
      return "";
    }

    String ans = s.substring(0, 1);

    for (int i = 1; i < s.length(); i++) {
      String one = midExpand(s, i, i);
      String two = midExpand(s, i - 1, i);
      ans = one.length() > ans.length()? one: ans;
      ans = two.length() > ans.length()? two: ans;
    }

    return ans;
  }

  private String midExpand(String s, int left, int right) {
    while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
      left--;
      right++;
    }
    return s.substring(left + 1, right);
  }
}
