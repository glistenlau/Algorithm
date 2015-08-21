/**
 * Valid Palindrome
 * www.lintcode.com/en/problem/valid-palindrome/
 *
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 *
 * Example
 * "A man, a plan, a canal: pananma" is a palindrome.
 * "race a car" is not a palindrome.
 */
public class Solution {
  /**
   * @param s A string
   * @return Whether the string is a valid palindrome
   */
  public boolean isPalindrome(String s) {
    // Write your code here
    if (s == null || s.length() == 0) {
      return true;
    }
    int left = 0;
    int right = s.length() - 1;
    while (left < right) {
      while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
        left++;
      }
      while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
        right--;
      }

      if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
        return false;
      }

      left++;
      right--;
    }
    return true;
  }
}
