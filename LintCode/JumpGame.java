/**
 * Jump Game
 * http://www.lintcode.com/en/problem/jump-game/
 *
 * Given an array of non-negative integers, you are initially positioned at
 * the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Determine if you are able to reach the last index.
 *
 * A = [2,3,1,1,4], return true.
 * A = [3,2,1,0,4], return false.
 */
public class Solution {
  /**
   * @param A: A list of integers
   * @return: The boolean answer
   */
  public boolean canJump(int[] A) {
    // wirte your code here
    if (A == null || A.length == 0) {
      return false;
    }
    int n = A.length;
    boolean[] jumpable = new boolean[n];
    jumpable[0] = true;
    for (int i = 1; i < n; i++) {
      for (int j = 0; j < i; j++) {
        jumpable[i] = jumpable[i] || jumpable[j] && A[j] >= i - j;
      }
    }
    return jumpable[n - 1];
  }
}