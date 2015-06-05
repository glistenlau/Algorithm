/**
 * Created by YiLIU on 6/5/15.
 */
public class UniquePathsII {
  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int m = obstacleGrid.length;
    if (m == 0) return 0;
    int n = obstacleGrid[0].length;
    int[][] ways = new int[m][n];
    ways[0][0] = 1;

    for (int i = 0; i < m; ++i) {
      for (int j = 0; j < n; ++j) {
        if (obstacleGrid[i][j] == 1)
          ways[i][j] = 0;
        else {
          ways[i][j] += i - 1 >= 0 ? ways[i - 1][j] : 0;
          ways[i][j] += j - 1 >= 0 ? ways[i][j - 1] : 0;
        }
      }
    }
    return ways[m - 1][n - 1];
  }
}
