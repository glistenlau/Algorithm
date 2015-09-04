/**
 * Scramble String
 * www.lintcode.com/en/problem/scramble-string/
 *
 * Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.
 */
public class Solution {
  /**
   * @param s1 A string
   * @param s2 Another string
   * @return whether s2 is a scrambled string of s1
   */
  public boolean isScramble(String s1, String s2) {
    // Write your code here
    if (s1.equals(s2)) {
      return true;
    }

    for (int i = 0; i < s1.length() - 1; i++) {
      String left = s1.substring(0, i + 1);
      String right = s1.substring(i + 1, s1.length());
      if (
          (isScramble(left, s2.substring(0, i + 1)) &&
              isScramble(right, s2.substring(i + 1, s1.length()))) ||
              (isScramble(left, s2.substring(s2.length() - i - 1, s2.length())) &&
                  isScramble(right, s2.substring(0, s2.length() - i - 1)))
          ) {
        return true;
      }
    }

    return false;
  }
}
