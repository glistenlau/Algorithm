/**
 * Longest Common Prefix
 * http://www.lintcode.com/en/problem/longest-common-prefix/
 *
 * Given k strings, find the longest common prefix (LCP).
 *
 * Example
 * For Strings "ABCD", "ABEF" and "ACEF", the LCP is "A".
 * For Strings "ABCDEFG", "ABCEFG" and "ABCEFA", the LCP is "ABC"
 */
public class Solution {
  /**
   * @param strs: A list of strings
   * @return: The longest common prefix
   */
  public String longestCommonPrefix(String[] strs) {
    // write your code here
    String result = new String();
    if (strs == null || strs.length == 0) {
      return result;
    }
    for (int i = 0; i < strs[0].length(); i++) {
      char temp = strs[0].charAt(i);
      for (int j = 1; j < strs.length; j++) {
        if (i >= strs[j].length() || strs[j].charAt(i) != temp) {
          return result;
        }
      }
      result += temp;
    }
    return result;
  }
}
