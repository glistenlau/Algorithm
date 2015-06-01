/**
 * Created by YiLIU on 5/31/15.
 */
public class CollectApple {
  public int maxAmount(int[][] grids) {

    int m = grids.length;
    if (m == 0) return 0;
    int n = grids[0].length;

    int[][] maxApple = new int[m][n];

    for (int i = 0; i < m; ++i) {
      for (int j = 0; j < n; ++j) {
        maxApple[i][j] = grids[i][j] + Math.max((i - 1 >= 0 ?
            maxApple[i - 1][j] : 0), (j - 1 >= 0 ? maxApple[i][j - 1] : 0));
      }
    }
    return maxApple[m - 1][n - 1];
  }

  public static void main (String[] args) {
    int[][] test = {{1,2,3,4},
        {2, 3, 4, 5}};
    System.out.println(new CollectApple().maxAmount(test));
  }
}
