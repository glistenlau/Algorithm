/**
 * Find Peak Element II
 * www.lintcode.com/en/problem/find-peak-element-ii/
 *
 * There is an integer matrix which has the following features:
 *   The numbers in adjacent positions are different.
 *   The matrix has n rows and m columns.
 *   For all i < m, A[0][i] < A[1][i] && A[n - 2][i] > A[n - 1][i].
 *   Foa all j < n, A[j][0] < A[j][1] && A[j][m - 2] > A[j][m - 1].
 *
 * We define a position P is a peak if:
 *   A[j][i] > A[j+1][i] && A[j][i] > A[j-1][i] && A[j][i] > A[j][i+1] && A[j][i] > A[j][i-1]
 *
 * Find a peak element in this matrix. Return the index of the peak.
 *
 * Example
 * Given a matrix:
 * [
 *   [1, 2, 3, 6, 5],
 *   [16, 41, 23, 22, 6],
 *   [15, 17, 24, 21, 7],
 *   [14, 18, 19, 20, 10],
 *   [13, 14, 11, 10, 9]
 * ]
 * return index of 41(which is [1, 1]) or index of 24(which is [2, 2]).
 */

class Solution {
  /**
   * @param A: An integer matrix
   * @return: The index of the peak
   */
  public List<Integer> findPeakII(int[][] A) {
    // write your code here
    List<Integer> result = new ArrayList<Integer>();
    if (A == null || A.length == 0) {
      return result;
    }
    int top = 1;
    int bot = A.length - 2;
    int left = 1;
    int right = A[0].length - 2;
    int row = 0;
    int col = 0;
    while(left <= right) {
      col = left + (right - left) / 2;
      while(top <= bot) {
        row = top + (bot - top) / 2;
        if (A[row][col] < A [row - 1][col]) {
          bot = row - 1;
        } else if (A[row][col] < A[row + 1][col]) {
          top = row + 1;
        } else {
          break;
        }
      }

      if (A[row][col] < A[row][col - 1]) {
        right = col - 1;
      } else if (A[row][col] < A[row][col + 1]) {
        left = col + 1;
      } else {
        result.add(row);
        result.add(col);
        return result;
      }
    }

    return result;
  }
}

