public class Solution {
  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int m = obstacleGrid.length;
    int n = obstacleGrid[0].length;
    int[][] paths = new int[m][n];

    if (obstacleGrid[0][0] == 1) {
      return 0;
    } else {
      paths[0][0] = 1;
    }

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (obstacleGrid[i][j] != 1) {
          paths[i][j] += j - 1 < 0? 0: paths[i][j - 1];
          paths[i][j] += i - 1 < 0? 0: paths[i - 1][j];
        }
      }
    }

    return paths[m - 1][n - 1];
  }
}