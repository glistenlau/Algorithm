/**
 * Length of Last Word
 * www.lintcode.com/en/problem/length-of-last-word/
 *
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return
 * the length of last word in the string.
 *
 * If the last word does not exist, return 0.
 *
 * Example
 * Given s = "Hello World", return 5.
 */
public class Solution {
  /**
   * @param s A string
   * @return the length of last word
   */
  public int lengthOfLastWord(String s) {
    // Write your code here
    int i = s.length() - 1;
    while (i >= 0 && s.charAt(i) == ' ') {
      i--;
    }
    int count = 0;
    while (i >= 0 && s.charAt(i) != ' ') {
      count++;
      i--;
    }

    return count;
  }
}
