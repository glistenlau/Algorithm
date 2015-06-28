/**
 * Word Break
 * http://www.lintcode.com/en/problem/word-break/
 *
 * Given a string s and a dictionary of words dict, determine if s can be
 * break into a space-separated sequence of one or more dictionary words.
 *
 * Example
 * Given s = "lintcode", dict = ["lint", "code"].
 *
 * Return true because "lintcode" can be break as "lint code".
 */
public class Solution {
  /**
   * @param s: A string s
   * @param dict: A dictionary of words dict
   */
  public boolean wordBreak(String s, Set<String> dict) {
    // write your code here
    if ((s == null || s.length() == 0) && dict != null && dict.size() != 0) {
      return false;
    }

    boolean[] inDict = new boolean[s.length() + 1];
    int max = getMaxLength(dict);
    inDict[0] = true;

    for (int i = 1; i <= s.length(); i++) {
      for (int j = 1; j <= i && j <= max; j++) {
        inDict[i] = inDict[i] || (dict.contains(s.substring(i - j, i)) && inDict[i - j]);
      }
    }
    return inDict[s.length()];
  }

  private int getMaxLength(Set<String> dict) {
    int max = 0;
    for (String str : dict) {
      max = Math.max(max, str.length());
    }
    return max;
  }
}
