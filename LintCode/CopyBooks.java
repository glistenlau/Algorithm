/**
 * Copy Books
 * www.lintcode.com/en/problem/copy-books/#
 *
 * Given an array A of integer with size of n(means n books and number of pages of each book) and k people
 * to copy the book. You must distribute the continuous id books to one people to copy. (You can have book
 * A[1], A[2] to one people, but you cannot give book A[1], A[3] to one people, beacause book A[1] and A[3]
 * is not continuous.) Each person can copy one page per minute. Return the number of smallest minutes need
 * to copy all books.
 *
 * Example
 * Given array A = [3, 2, 4], k = 2.
 * Return 5 (First person spends 5 minutes to copy book 1 and book 2 and second person spends 4 minutes to copy
 * book 3.)
 */
public class Solution {
  /**
   * @param pages: an array of integers
   * @param k: an integer
   * @return: an integer
   */
  private int[][] getSums(int[] pages) {
    int[][] sums = new int[pages.length + 1][pages.length + 1];
    for (int i = 1; i <= pages.length; i++) {
      for (int j = i; j <= pages.length; j++) {
        sums[i][j] = sums[i][j - 1] + pages[j - 1];
      }
    }

    return sums;

  }
  public int copyBooks(int[] pages, int k) {
    // write your code here
    if (pages == null || pages.length == 0) {
      return 0;
    }

    int[][] dp = new int[pages.length + 1][k + 1];
    int[][] sums = getSums(pages);

    for (int i = 1; i <= pages.length; i++) {
      dp[i][0] = Integer.MAX_VALUE;
    }

    for (int i = 1; i <= pages.length; i++) {
      for (int j = 1; j <= k; j++) {
        dp[i][j] = Integer.MAX_VALUE;
        for (int n = 0; n < i; n++) {
          dp[i][j] = Math.min(dp[i][j], Math.max(dp[n][j - 1], sums[n + 1][i]));
        }
      }
    }

    return dp[pages.length][k];
  }
}
