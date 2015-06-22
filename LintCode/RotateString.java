/**
 * Rotate String
 * http://www.lintcode.com/en/problem/rotate-string/
 *
 * Given a string and an offset, rotate string by offset. (rotate from left to right)
 *
 * Example
 * Given "abcdefg".
 *
 * offset=0 => "abcdefg"
 * offset=1 => "gabcdef"
 * offset=2 => "fgabcde"
 * offset=3 => "efgabcd"
 */
public class Solution {
  /*
   * param A: A string
   * param offset: Rotate string with offset.
   * return: Rotated string.
   */
  public char[] rotateString(char[] A, int offset) {
    // wirte your code here
    if (A == null || A.length == 0) {
      return A;
    }
    if (offset > A.length) {
      offset = offset % A.length;
    }
    rotate(A, 0, A.length - offset);
    rotate(A, A.length - offset, A.length);
    rotate(A, 0, A.length);
    return A;
  }
  private void rotate(char[] A, int s, int e) {
    while (s < e - 1) {
      char temp = A[e - 1];
      A[e - 1] = A[s];
      A[s] = temp;
      s++;
      e--;
    }
  }
}