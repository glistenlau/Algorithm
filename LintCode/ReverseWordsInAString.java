/**
 * Reverse Words in a String
 * http://www.lintcode.com/en/problem/reverse-words-in-a-string/
 *
 * Given an input string, reverse the string word by word.
 *
 * For example,
 * Given s = "the sky is blue",
 * return "blue is sky the".
 */
public class Solution {
  /**
   * @param s : A string
   * @return : A string
   */
  public String reverseWords(String s) {
    // write your code
    String result = "";
    int l = s.length() - 1;
    int r = s.length();
    while (l >= 0) {
      if (s.charAt(l) == ' ') {
        l--;
        continue;
      }
      r = l + 1;
      while (l >= 0 && s.charAt(l) != ' ') {
        l--;
      }
      result += s.substring(l + 1, r) + " ";
    }
    return result;
  }
}