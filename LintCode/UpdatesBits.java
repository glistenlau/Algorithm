/**
 * Updates Bits
 * www.lintcode.com/en/problem/update-bits/
 *
 * Given two 32-bit numbers, N and M, and two bit positions, i and j. Write a
 * method to set all bits between i and j  in N equal to M (eg, M becomes a
 * substring of N located at i and starting at j)
 *
 * Example
 * Given N = (100000000000)2, M = (10101)2, i = 2, j = 6.
 * return N = (10001010100)2.
 */

class Solution {
  /**
   *@param n, m: Two integer
   *@param i, j: Two bit positions
   *return: An integer
   */
  public int updateBits(int n, int m, int i, int j) {
    int mask;
    if (j < 31) {
      mask = ~((1 << (j + 1)) - (1 << i));
    } else {
      mask = (1 << i) - 1;
    }
    return ((m << i) + (mask & n));
  }
}

