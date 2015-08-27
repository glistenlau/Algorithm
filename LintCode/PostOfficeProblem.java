/**
 * Post Office Problem
 * www.lintcode.com/en/problem/post-office-problem/
 *
 * On one line there are n houses. Give you an array of integer means the position of each house. Now you need to pick k position to build
 * k post office, so that the sum distance of each house to the nearest post office is the smallest. Return the least possible sum of all
 * distances between each village and its nearest post office.
 *
 * Example
 * Given array a = [1, 2, 3, 4, 5], k = 2, return 3.
 */
public class Solution {
  /**
   * @param A an integer array
   * @param k an integer
   * @return an integer
   */
  public int postOffice(int[] A, int k) {
    if (A == null || A.length == 0) {
      return 0;
    }
    Arrays.sort(A);

    int[][] diff = getDiff(A);
    int[][] dp = new int[A.length + 1][k + 1];

    for (int i = 1; i <= A.length; i++) {
      dp[i][1] = diff[0][i - 1];
    }


    for (int i = 1; i <= A.length; i++) {
      for (int n = 2; n <= k; n++) {
        dp[i][n] = Integer.MAX_VALUE;
        for (int j = 0; j < i; j++) {
          dp[i][n] = Math.min(dp[i][n], dp[j][n - 1] + diff[j][i - 1]);
        }
      }
    }

    return dp[A.length][k];
  }

  private int[][] getDiff(int[] A) {
    int[][] diff = new int[A.length][A.length];

    for (int i = 0; i < A.length; i++) {
      for (int j = i + 1; j < A.length; j++) {
        int mid = i + (j - i) / 2;
        for (int k = i; k <=j; k++) {
          diff[i][j] += Math.abs(A[k] - A[mid]);
        }
      }
    }

    return diff;
  }
}
