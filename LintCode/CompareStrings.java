/**
 * Compare Strings
 * http://www.lintcode.com/en/problem/compare-strings/
 *
 * Compare two strings A and B determine whether A contains all of the
 * characters in B.
 *
 * The characters in string A and B are all Upper Case letters.
 *
 * Example
 * For A = "ABCD", B = "ACD", return true.
 * For A = "ABCE", B = "AABC", return false.
 */
public class Solution {
  /**
   * @param A : A string includes Upper Case letters
   * @param B : A string includes Upper Case letter
   * @return :  if string A contains all of the characters in B return true else return false
   */
  public boolean compareStrings(String A, String B) {
    // write your code here
    if (A.length() < B.length()) {
      return false;
    }
    int[] lookup = new int[256];
    for (int i = 0; i < A.length(); i++) {
      lookup[A.charAt(i)] += 1;
    }
    for (int i = 0; i < B.length(); i++) {
      lookup[B.charAt(i)] -= 1;
      if (lookup[B.charAt(i)] < 0) {
        return false;
      }
    }
    return true;
  }
}
