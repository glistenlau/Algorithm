/**
 * Minimum Adjustment Cost
 * http://www.lintcode.com/en/problem/minimum-adjustment-cost/
 *
 * Given an integer array, adjust each integers so that the difference of
 * every adjacent integers are not greater than a given number target.
 *
 * If the array before adjustment is A, the array after adjustment is B, you
 * should minimize the sum of |A[i] - B[i]|
 *
 * Example
 * Given [1, 4, 2, 3] and target = 1, one or the solution is [2, 3, 2, 3],
 * the adjustment cost is 2 and it's minimal.
 *
 * Return 2.
 *
 * Note
 * You can assume each number in the array is a positive and not greater than
 * 100.
 */
public class Solution {
  /**
   * @param A: An integer array.
   * @param target: An integer.
   */
  public int MinAdjustmentCost(ArrayList<Integer> A, int target) {
    // write your code here
    if (A == null || A.size() == 0) {
      return 0;
    }
    int[][] minAdj = new int[A.size()][101];
    for (int n = 0; n < 101; n++) {
      minAdj[0][n] = Math.abs(A.get(0) - n);
    }
    for (int i = 1; i < A.size(); i++) {
      for (int n = 0; n < 101; n++) {
        minAdj[i][n] = Integer.MAX_VALUE;
        for (int j = 0; j < 101; j++) {
          if (Math.abs(n - j) > target) {
            continue;
          }
          minAdj[i][n] = Math.min(minAdj[i][n], minAdj[i - 1][j] + Math.abs(n - A.get(i)));
        }
      }
    }
    int min = Integer.MAX_VALUE;
    for (int n = 0; n < 101; n++) {
      if (minAdj[A.size() - 1][n] < min) {
        min = minAdj[A.size() - 1][n];
      }
    }
    return min;
  }
}


