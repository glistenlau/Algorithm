public class Solution {
  public int numIslands(char[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0) {
      return 0;
    }

    int ans = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == '1') {
          ans += 1;
          expand(grid, i, j);
        }
      }
    }

    return ans;
  }

  private void expand(char[][] grid, int row, int col) {
    grid[row][col] = '0';
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    for (int i = 0; i < 4; i++) {
      int r = row + dx[i];
      int c = col + dy[i];
      if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length) {
        if (grid[r][c] == '1') {
          expand(grid, r, c);
        }
      }
    }
  }
}