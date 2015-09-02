/**
 * Delete Digits
 * Given string A representative a positive integer which has N digits, remove any k
 * digits of the number, the remaining digits are arranged according to the original
 * order to become a new positive integer.
 *
 * Find the smallest integer after remove k digits.
 *
 * Example
 * Given an integer A = "18542", k = 4.
 * Return a string "12".
 */
public class Solution {
  /**
   *@param A: A positive integer which has N digits, A is a string.
   *@param k: Remove k digits.
   *@return: A string
   */
  public String DeleteDigits(String A, int k) {
    // write your code here
    StringBuilder sb = new StringBuilder(A);

    for (int i = 0; i < k; i++) {
      for (int j = 0; j < sb.length(); j++) {
        if (j == sb.length() - 1) {
          sb.deleteCharAt(j);
        } else if (sb.charAt(j) > sb.charAt(j + 1)) {
          sb.deleteCharAt(j);
          break;
        }
      }
    }

    int i = 0;
    while (i < sb.length() - 1 && sb.charAt(i) == '0') {
      sb.deleteCharAt(i);
    }

    return sb.toString();
  }
}
