/**
 * Created by YiLIU on 6/5/15.
 */
public class UniquePaths {
  public long howMany(int m, int n) {
    if (m == 0 || n == 0) return 0;
    int[][] ways = new int[m][n];
    ways[0][0] = 1;
    for (int i = 0; i < m; ++i) {
      for (int j = 0; j < n; ++j) {
        ways[i][j] += i - 1 >= 0 ? ways[i - 1][j] : 0;
        ways[i][j] += j - 1 >= 0 ? ways[i][j - 1] : 0;
      }
    }
    return ways[m - 1][n - 1];
  }
}
